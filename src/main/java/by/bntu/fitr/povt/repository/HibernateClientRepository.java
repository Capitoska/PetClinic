package by.bntu.fitr.povt.repository;

import by.bntu.fitr.povt.model.Client;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HibernateClientRepository extends HibernateRepository<Client> implements ClientRepository {
//
//    public List<T> findAll(Class<T> clazz) {
//        return sessionFactory.getCurrentSession()
//                .createQuery("from " + clazz.getSimpleName())
//                .list();
//    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Client> findByIdPet(int idPet) {
        return sessionFactory.getCurrentSession().createNativeQuery("select clients.* " +
                "from clients " +
                "join client_pets pet on clients.id = pet.client_id " +
                "join pets p on pet.pet_id = p.id " +
                "where pet.pet_id = :idPet")
                .setParameter("idPet", idPet)
                .addEntity("clients", Client.class)
                .list();
    }

    @Override
    public Client findById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Client  where id = :id");
        query.setParameter("id", id);
        return (Client) query.uniqueResult();
    }

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
