package by.bntu.fitr.povt.repository;

import by.bntu.fitr.povt.model.Client;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HibernateClientRepository extends HibernateRepository<Client> implements ClientRepository {
    @Override
    public Client findByUsername(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Client " +
                "where username = :username");

        query.setParameter("username", name);
        return (Client) query.uniqueResult();
    }

    @Override
    public List<Client> findAll() {
        return this.findAll(Client.class);
    }
}
