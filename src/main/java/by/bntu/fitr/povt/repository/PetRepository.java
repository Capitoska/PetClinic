package by.bntu.fitr.povt.repository;

import by.bntu.fitr.povt.model.Pet;

public interface PetRepository {
    Pet findByIdPet(Integer id);
    void save(Pet pet);
}
