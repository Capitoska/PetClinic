package by.bntu.fitr.povt.service;

import by.bntu.fitr.povt.dto.SignUpUserDto;
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
public class DefaultClientService implements ClientService {

    @Setter(onMethod_ = @Autowired)
    private ClientRepository clientRepository;

    @Setter(onMethod_ = @Autowired)
    private PetRepository petRepository;


    @Override
    @Transactional
    public void removePetById(Client client, Integer idPet) {
        clientRepository.deletePetFromClient(client,petRepository.findByIdPet(idPet));
    }

    @Override
    @Transactional
    public void createClient(Client client) {
        clientRepository.save(client);
    }

    @Override
    public void createClient(SignUpUserDto signUpUserDto) {

    }

    @Override
    @Transactional
    public Client getClientById(Integer id) {
        return  clientRepository.findById(id);
    }

    @Override
    public Client getClientByUsernameAndPassword(String username, String password) {
        return clientRepository.getClientByUsernameAndPassword(username,password);
    }

    @Override
    @Transactional
    public void addPet(Client client, Pet pet) {
        client.getPets().add(pet);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Client> getAll() {
        return clientRepository.findAll(Client.class);
    }

    @Override
    @Transactional
    public Client getClientByUsername(String username) {
        return clientRepository.findByUsername(username);
    }

    @Override
    @Transactional
    public void update(Client client) {
        clientRepository.update(client);
    }

    @Override
    @Transactional
    public List<Client> getClientsByPetId(int petId) {
        return clientRepository.findByIdPet(petId);
    }
}
