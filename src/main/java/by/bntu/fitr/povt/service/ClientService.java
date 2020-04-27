package by.bntu.fitr.povt.service;

import by.bntu.fitr.povt.dto.SignUpUserDto;
import by.bntu.fitr.povt.model.Client;
import by.bntu.fitr.povt.model.Pet;

import java.util.List;

public interface ClientService {

    void removePetById(Client client, Integer idPet);

    void createClient(Client client);
    void createClient(SignUpUserDto signUpUserDto);

    Client getClientById(Integer id);

    Client getClientByUsernameAndPassword(String username, String password);

    void addPet(Client client, Pet pet);

    List<Client> getAll();

    Client getClientByUsername(String username);

    void update(Client client);

    List<Client> getClientsByPetId(int petId);
}
