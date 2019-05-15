package by.bntu.fitr.povt.service;

import by.bntu.fitr.povt.model.Client;
import by.bntu.fitr.povt.model.Pet;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface ClientService {

    void removePetById(Client client, Integer idPet);

    void createClient(Client client);

    Client getClientById(Integer id);

    void addPet(Client client, Pet pet);

    List<Client> getAll();

    Client getClientByUsername(String username);

    void update(Client client);

    List<Client> getClientsByPetId(int petId);
}
