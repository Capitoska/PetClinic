package by.bntu.fitr.povt.service;

import by.bntu.fitr.povt.model.Client;
import by.bntu.fitr.povt.model.DiseaseHistory;
import by.bntu.fitr.povt.model.DoctorInfo;
import by.bntu.fitr.povt.model.Specialty;
import by.bntu.fitr.povt.repository.DiseaseHistoryRepository;
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
    private DiseaseHistoryRepository diseaseHistoryRepository;

    @Override
    @Transactional
    public Client getDoctorByUsername(String username) {
        return doctorRepository.findByUsername(username);
    }

    // TODO: 5/19/2019 не забыть сделать для доктора.
    @Override
    @Transactional
    public List<DiseaseHistory> getAllDiseaseBySpecialty(Specialty specialty)
    {
        return diseaseHistoryRepository.getAllDiseaseBySpecialty(specialty);
    }

    @Override
    @Transactional
    public void createDoctor(Client client, DoctorInfo doctorInfo) {
        log.info("Work create Client");
        doctorInfoRepository.saveOrUpdate(doctorInfo);
        doctorRepository.save(client);
    }

    @Override
    @Transactional
    public void updateDoctor(Client client, DoctorInfo doctorInfo) {
        log.info("Work UpdateDoctor");
        doctorInfoRepository.update(doctorInfo);
        doctorRepository.update(client);
    }
}
