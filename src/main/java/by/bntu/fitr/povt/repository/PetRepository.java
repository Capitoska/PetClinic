package by.bntu.fitr.povt.repository;

import by.bntu.fitr.povt.model.Client;
import by.bntu.fitr.povt.model.Pet;

public interface PetRepository extends Repository<Pet> {
    Pet findByIdPet(Integer id);

}
