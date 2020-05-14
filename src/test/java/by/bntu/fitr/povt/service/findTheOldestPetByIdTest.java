package by.bntu.fitr.povt.service;

import by.bntu.fitr.povt.Main;
import by.bntu.fitr.povt.model.Client;
import by.bntu.fitr.povt.model.Pet;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@Log4j2
@SpringBootTest(classes = Main.class)
@ExtendWith(SpringExtension.class)
public class findTheOldestPetByIdTest {

    @Autowired
    ClientService clientService;

    @Autowired
    PetService petService;


    @Test
    public void withoutPetsNull() {
        Client client = clientService.getClientByUsername("TestClient");
        assertNull(petService.findTheOldestPetByOwnerId(client.getId()));
    }

    @Test
    public void withOnePet() {
        Client client = clientService.getClientByUsername("TestClient");
        Pet firstPet = petService.getPetbyId(2);
        clientService.addPet(client, firstPet);
        clientService.update(client);
        log.info(client.getPets());
        assertEquals(petService.findTheOldestPetByOwnerId(client.getId()).getId(), firstPet.getId());
        client.getPets().clear();
        clientService.update(client);
    }

    @Test
    public void firstPetOldest() {
        Client client = clientService.getClientByUsername("TestClient");
        Pet firstOldestPet = petService.getPetbyId(2);
        clientService.addPet(client, firstOldestPet);
        Pet secondPet = petService.getPetbyId(3);
        Pet thirdPet = petService.getPetbyId(1);
        clientService.addPet(client, secondPet);
        clientService.addPet(client, thirdPet);
        clientService.update(client);

        assertEquals(petService.findTheOldestPetByOwnerId(client.getId()).getId(), firstOldestPet.getId());
        client.getPets().clear();
        clientService.update(client);
    }

    @Test
    public void firstPetNotOldest() {
        Client client = clientService.getClientByUsername("TestClient");
        Pet firstPet = petService.getPetbyId(3);
        Pet secondOldestPet = petService.getPetbyId(2);
        Pet thirdPet = petService.getPetbyId(1);
        clientService.addPet(client, firstPet);
        clientService.addPet(client, secondOldestPet);
        clientService.addPet(client, thirdPet);
        clientService.update(client);
        assertEquals(petService.findTheOldestPetByOwnerId(client.getId()).getId(), secondOldestPet.getId());
        client.getPets().clear();
        clientService.update(client);
    }
}
