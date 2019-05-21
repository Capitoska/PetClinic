    package by.bntu.fitr.povt.repository;

    import by.bntu.fitr.povt.model.Client;
    import by.bntu.fitr.povt.model.DiseaseHistory;
    import by.bntu.fitr.povt.model.Pet;
    import by.bntu.fitr.povt.model.Specialty;
    import org.hibernate.Session;
    import org.hibernate.query.Query;
    import org.springframework.stereotype.Repository;

    import java.util.List;

    @Repository
    public class HibernateDiseaseHistoryRepository extends HibernateRepository<DiseaseHistory> implements DiseaseHistoryRepository {
        @Override
        public void createDiseaseHistory(DiseaseHistory history) {
            this.save(history);
        }




        @Override
        public List<DiseaseHistory> findAllDiseaseHistoryByPet(Pet pet) {
            Session session = sessionFactory.getCurrentSession();
            Query query = session.createQuery("from DiseaseHistory where pet=:pet");
            query.setParameter("pet", pet);
            return query.list();
        }

        @Override
        public DiseaseHistory getDiseaseHistoryById(Integer id) {
            Session session = sessionFactory.getCurrentSession();
            Query query = session.createQuery("from DiseaseHistory where id=:id");
            query.setParameter("id", id);
            return (DiseaseHistory) query.uniqueResult();
        }

        @Override
        public List<DiseaseHistory> getAllDiseaseBySpecialty(Specialty specialty) {
            Session session= sessionFactory.getCurrentSession();
            Query query = session.createQuery("from DiseaseHistory where doctorType=:specialty");
            query.setParameter("specialty",specialty);
            return query.list();
        }

    //    Session session = sessionFactory.getCurrentSession();
    //    Query query = session.createQuery("from Client " +
    //            "where username = :username");
    //
    //        query.setParameter("username", username);
    //        return (Client) query.uniqueResult();


        // TODO: 5/19/2019 проверить все методы.


    }
