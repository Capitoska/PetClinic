package by.bntu.fitr.povt.service;

import by.bntu.fitr.povt.model.Client;
import by.bntu.fitr.povt.repository.ClientRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DefaultClientService implements ClientService {

    @Setter(onMethod_ = @Autowired)
    private ClientRepository clientRepository;

    @Override
    @Transactional
    public void createClient(Client client) {
        clientRepository.save(client);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Client> getAll() {
        return clientRepository.findAll();
    }
}
