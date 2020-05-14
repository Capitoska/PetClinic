package by.bntu.fitr.povt.repository;

import by.bntu.fitr.povt.model.Client;
import by.bntu.fitr.povt.model.Pet;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HibernateClientRepository extends HibernateRepository<Client> implements ClientRepository {

    @Override
    public Client getClientByUsernameAndPassword(String username, String password) {
        return (Client) sessionFactory.getCurrentSession().createQuery("from Client " +
                "where username=:username and password=:password")
                .setParameter("password", password).setParameter("username", username).uniqueResult();
    }

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
    public void deletePetFromClient(Client client, Pet pet) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete from ClientPet where pet=:pet and client=:client");
        query.setParameter("pet", pet);
        query.setParameter("client", client);
        int result = query.executeUpdate();
    }

    @Override
    public Client findByUsername(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Client " +
                "where username = :username");

        query.setParameter("username", name);
        return (Client) query.uniqueResult();
    }

    public List<Client> findAll() {
        return this.findAll(Client.class);
    }
}
