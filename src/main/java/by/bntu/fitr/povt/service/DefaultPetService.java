package by.bntu.fitr.povt.service;

import by.bntu.fitr.povt.model.Client;
import by.bntu.fitr.povt.model.Pet;
import by.bntu.fitr.povt.repository.ClientRepository;
import by.bntu.fitr.povt.repository.PetRepository;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Log4j2
public class DefaultPetService implements PetService {

    @Setter(onMethod_ = @Autowired)
    private PetRepository petRepository;

    @Setter(onMethod_ = @Autowired)
    private ClientRepository clientRepository;

    @Override
    @Transactional
    public Pet findTheOldestPetByOwnerId(int id) {
        Client client = clientRepository.findById(id);
        Pet oldestPet = null;
        List<Pet> pets = client.getPets();
        if (pets.size() != 0) {
            oldestPet = pets.get(0);
            for (int i = 0; i < pets.size(); i++) {
                if (oldestPet.getAge() < pets.get(i).getAge()) {
                    oldestPet = pets.get(i);
                }
            }
        }
        return oldestPet;
    }

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
