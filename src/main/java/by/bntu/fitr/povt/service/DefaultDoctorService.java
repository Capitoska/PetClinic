package by.bntu.fitr.povt.service;

import by.bntu.fitr.povt.dto.SignUpUserDto;
import by.bntu.fitr.povt.model.Client;
import by.bntu.fitr.povt.model.DiseaseHistory;
import by.bntu.fitr.povt.model.DoctorInfo;
import by.bntu.fitr.povt.model.Specialty;
import by.bntu.fitr.povt.repository.DiseaseHistoryRepository;
import by.bntu.fitr.povt.repository.DoctorCardsRepository;
import by.bntu.fitr.povt.repository.DoctorRepository;
import by.bntu.fitr.povt.repository.Repository;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Log4j2
@Service
public class DefaultDoctorService implements DoctorService {
    @Setter(onMethod_ = @Autowired)
    private DoctorRepository doctorRepository;
    @Setter(onMethod_ = @Autowired)
    private Repository<DoctorInfo> doctorInfoRepository;

    @Setter(onMethod_ = @Autowired)
    private DoctorCardsRepository doctorCardsRepository;

    @Setter(onMethod_ = @Autowired)
    private DiseaseHistoryRepository diseaseHistoryRepository;

    @Override
    @Transactional
    public Client getDoctorByUsername(String username) {
        return doctorRepository.findByUsername(username);
    }

    // TODO: 5/19/2019 не забыть сделать для доктора.
    @Override
    @Transactional
    public List<DiseaseHistory> getAllDiseaseBySpecialty(Specialty specialty) {
        return diseaseHistoryRepository.getAllDiseaseBySpecialty(specialty);
    }

    @Override
    @Transactional
    public boolean isDoctorCardByName(String cardName) {
        return doctorCardsRepository.find(cardName) != null;
    }


    @Override
    @Transactional
    public boolean createDoctor(Client client) {
        log.info("Work create Doctor");
        log.info(doctorCardsRepository.find(client.getIdCard()));
        if (isDoctorCardByName(client.getIdCard())) {
            doctorInfoRepository.saveOrUpdate(client.getDoctorInfo());
            doctorRepository.save(client);
            doctorCardsRepository.deleteByCard(client.getIdCard());
            return true;
        }
        return false;
    }


    @Override
    @Transactional
    public boolean createDoctor(SignUpUserDto client) {
        if (isDoctorCardByName(client.getIdCard())) {
            DoctorInfo doctorInfo = new DoctorInfo();
            doctorInfo.setSpecialty(Specialty.valueOf(client.getSpecialistic()));
            Client doctor = Client.builder().password(client.getPassword())
                    .firstName(client.getFirstName())
                    .secondName(client.getSecondName())
                    .username(client.getNickName())
                    .phoneNumber(Long.parseLong(client.getPhone()))
                    .idCard(client.getIdCard())
                    .doctorInfo(doctorInfo)
                    .build();
            doctorInfoRepository.saveOrUpdate(doctor.getDoctorInfo());
            doctorRepository.save(doctor);
            doctorCardsRepository.deleteByCard(doctor.getIdCard());
            return true;
        }
        return false;
    }


    @Override
    @Transactional
    public void updateDoctor(Client client) {
        log.info("Work UpdateDoctor");
        doctorInfoRepository.update(client.getDoctorInfo());
        doctorRepository.update(client);
    }
}
