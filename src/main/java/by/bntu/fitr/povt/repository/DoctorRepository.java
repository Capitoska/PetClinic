package by.bntu.fitr.povt.repository;

import by.bntu.fitr.povt.model.Client;

public interface DoctorRepository extends Repository<Client> {

    Client findByUsername(String username);
}
