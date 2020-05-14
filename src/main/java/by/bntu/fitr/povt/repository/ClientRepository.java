package by.bntu.fitr.povt.repository;

import by.bntu.fitr.povt.model.Client;
import by.bntu.fitr.povt.model.Pet;

import java.util.List;

public interface ClientRepository extends Repository<Client> {
    Client getClientByUsernameAndPassword(String username, String password);

    List<Client> findByIdPet(int idPet);

    Client findById(Integer id);

    void deletePetFromClient(Client client, Pet pet);

    Client findByUsername(String name);
}
