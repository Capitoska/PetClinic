package by.bntu.fitr.povt.repository;

import by.bntu.fitr.povt.model.DiseaseHistory;
import org.springframework.stereotype.Repository;

@Repository
public class HibernateDiseaseHistoryRepository extends  HibernateRepository<DiseaseHistory> implements  DiseaseHistoryRepository {


}
