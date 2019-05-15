package by.bntu.fitr.povt.service;

import by.bntu.fitr.povt.model.Pet;

public interface PetService {
    void createPet(Pet pet);
    Pet getPetbyId(int Id);
    void update(Pet pet);
}
