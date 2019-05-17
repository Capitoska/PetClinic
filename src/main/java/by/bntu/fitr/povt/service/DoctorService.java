package by.bntu.fitr.povt.service;

import by.bntu.fitr.povt.model.Doctor;
import by.bntu.fitr.povt.model.DoctorInfo;

public interface DoctorService {
    Doctor getDoctorByUsername(String username);
    void createDoctor(Doctor doctor, DoctorInfo doctorInfo);
    void updateDoctor(Doctor doctor, DoctorInfo doctorInfo);
}
