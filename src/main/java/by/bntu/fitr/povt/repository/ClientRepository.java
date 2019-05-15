package by.bntu.fitr.povt.repository;

import by.bntu.fitr.povt.model.Client;

import java.util.List;

public interface ClientRepository {

    List<Client> findByIdPet(int idPet);

    Client findById(Integer id);

    Client findByUsername(String name);

    void save(Client client);

    List<Client> findAll();

    void update(Client client);
}
