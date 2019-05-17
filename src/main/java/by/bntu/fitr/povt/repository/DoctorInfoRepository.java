package by.bntu.fitr.povt.repository;

import by.bntu.fitr.povt.model.DoctorInfo;

public interface DoctorInfoRepository {
    void save(DoctorInfo doctorInfo);

    void update(DoctorInfo doctorInfo);

    void saveOrUpdate(DoctorInfo doctorInfo);
}
