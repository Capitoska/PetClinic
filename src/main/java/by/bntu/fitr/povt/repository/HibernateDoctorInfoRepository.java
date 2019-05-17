package by.bntu.fitr.povt.repository;

import by.bntu.fitr.povt.model.DoctorInfo;
import org.springframework.stereotype.Repository;

@Repository
public class HibernateDoctorInfoRepository extends HibernateRepository<DoctorInfo> implements DoctorInfoRepository {
}
