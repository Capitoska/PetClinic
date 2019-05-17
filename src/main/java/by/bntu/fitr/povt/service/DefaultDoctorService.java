package by.bntu.fitr.povt.service;

import by.bntu.fitr.povt.model.Doctor;
import by.bntu.fitr.povt.model.DoctorInfo;
import by.bntu.fitr.povt.repository.DoctorInfoRepository;
import by.bntu.fitr.povt.repository.DoctorRepository;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Log4j2
@Service
public class DefaultDoctorService implements DoctorService {
    @Setter(onMethod_ = @Autowired)
    private DoctorRepository doctorRepository;
    @Setter(onMethod_ = @Autowired)
    private DoctorInfoRepository doctorInfoRepository;

    @Override
    @Transactional
    public Doctor getDoctorByUsername(String username) {
        return doctorRepository.findByUsername(username);
    }

    @Override
    @Transactional
    public void createDoctor(Doctor doctor, DoctorInfo doctorInfo) {
        log.info("Work create Doctor");
        doctorInfoRepository.saveOrUpdate(doctorInfo);
        doctorRepository.save(doctor);
    }

    @Override
    @Transactional
    public void updateDoctor(Doctor doctor, DoctorInfo doctorInfo) {
        log.info("Work UpdateDoctor");
        doctorInfoRepository.update(doctorInfo);
        doctorRepository.update(doctor);
    }
}
