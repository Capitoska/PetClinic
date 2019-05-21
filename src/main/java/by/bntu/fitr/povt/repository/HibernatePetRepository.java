package by.bntu.fitr.povt.repository;

import by.bntu.fitr.povt.model.Client;
import by.bntu.fitr.povt.model.Pet;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class HibernatePetRepository extends HibernateRepository<Pet> implements PetRepository {

    @Override
    public Pet findByIdPet(Integer id) {
        return find(Pet.class, id).orElse(null);
    }



    @Override
    public void save(Pet entity) {
        super.save(entity);
    }


}
