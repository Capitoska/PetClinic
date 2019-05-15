package by.bntu.fitr.povt.service;

import by.bntu.fitr.povt.model.Pet;
import by.bntu.fitr.povt.repository.ClientRepository;
import by.bntu.fitr.povt.repository.PetRepository;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Log4j2
public class DefaultPetService implements PetService {

    @Setter(onMethod_ = @Autowired)
    private PetRepository petRepository;

    @Override
    @Transactional
    public void createPet(Pet pet) {
        petRepository.save(pet);
    }

    @Override
    @Transactional
    public Pet getPetbyId(int id) {
        return petRepository.findByIdPet(id);
    }

    @Override
    @Transactional
    public void update(Pet pet) {

    }

}
