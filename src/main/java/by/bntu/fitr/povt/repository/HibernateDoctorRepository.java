package by.bntu.fitr.povt.repository;

import by.bntu.fitr.povt.model.Client;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class HibernateDoctorRepository extends HibernateRepository<Client> implements DoctorRepository {
    @Override
    public Client findByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Client " +
                "where username = :username");

        query.setParameter("username", username);
        return (Client) query.uniqueResult();
    }

}
