package by.bntu.fitr.povt;

import by.bntu.fitr.povt.model.Client;
import by.bntu.fitr.povt.model.Pet;
import by.bntu.fitr.povt.service.ClientService;
import by.bntu.fitr.povt.service.PetService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Log4j2
@AllArgsConstructor
public class Test {

    private ClientService clientService;
    private PetService petService;
    @EventListener
    public void on(ApplicationReadyEvent event) {
        log.info(petService.getPetbyId(4));
        List<Client> clients = clientService.getClientsByPetId(4);
        log.info(clients);
    }
}
