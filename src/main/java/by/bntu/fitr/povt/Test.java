package by.bntu.fitr.povt;

import by.bntu.fitr.povt.model.Client;
import by.bntu.fitr.povt.model.DiseaseHistory;
import by.bntu.fitr.povt.model.Pet;
import by.bntu.fitr.povt.model.Specialty;
import by.bntu.fitr.povt.service.ClientService;
import by.bntu.fitr.povt.service.DoctorService;
import by.bntu.fitr.povt.service.PetService;
import by.bntu.fitr.povt.service.VisitService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@Log4j2
@AllArgsConstructor
public class Test {

    private VisitService visitService;
    private ClientService clientService;
    private PetService petService;
    private DoctorService doctorService;

    @EventListener
    public void on(ApplicationReadyEvent event) {
        Client client = clientService.getClientById(8);
        Pet pet = petService.getPetbyId(4);
//        log.info(pet.getName());
//        log.info(client.getUsername());
//        visitService.addVisit(client, pet, "Не открывается одно глазко", LocalDate.now(), Specialty.DENTIST);
//        visitService.addVisit(client, pet, "Пришёл с большим шрамом.", LocalDate.now(), Specialty.DENTIST);
        DiseaseHistory history = visitService.getDiseaseHistoryById(4);
        visitService.doctorAnswer(history,client,"С вашим питомцем все хорошо!");

    }
}
