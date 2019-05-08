package by.bntu.fitr.povt.service;

import by.bntu.fitr.povt.model.Client;

import java.util.List;

public interface ClientService {

    void createClient(Client client);

    List<Client> getAll();
}
