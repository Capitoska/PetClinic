package by.bntu.fitr.povt.repository;

import by.bntu.fitr.povt.model.Pet;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class HibernatePetRepository extends HibernateRepository<Pet> implements PetRepository {

    @Override
    public Pet findByIdPet(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Pet where id = :id");
        query.setParameter("id", id);
        return (Pet) query.uniqueResult();
    }

    @Override
    public void save(Pet entity) {
        super.save(entity);
    }


//    public Client findByUsername(String name) {
//        Session session = sessionFactory.getCurrentSession();
//        Query query = session.createQuery("from Client " +
//                "where username = :username");
//
//        query.setParameter("username", name);;
//        return (Client) query.uniqueResult();
//    }
}
