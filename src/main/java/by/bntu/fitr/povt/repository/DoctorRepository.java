package by.bntu.fitr.povt.repository;

import by.bntu.fitr.povt.model.Doctor;
import by.bntu.fitr.povt.model.DoctorInfo;

public interface DoctorRepository {
    void save(Doctor doctor);

    void update(Doctor doctor);

    Doctor findByUsername(String username);
}
