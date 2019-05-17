package by.bntu.fitr.povt.repository;

import by.bntu.fitr.povt.model.Client;
import by.bntu.fitr.povt.model.Doctor;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class HibernateDoctorRepository extends HibernateRepository<Doctor> implements DoctorRepository {
    @Override
    public Doctor findByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Doctor " +
                "where username = :username");

        query.setParameter("username", username);
        return (Doctor) query.uniqueResult();
    }

}
