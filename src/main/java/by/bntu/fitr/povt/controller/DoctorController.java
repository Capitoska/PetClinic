package by.bntu.fitr.povt.controller;


import by.bntu.fitr.povt.model.Client;
import by.bntu.fitr.povt.model.Pet;
import by.bntu.fitr.povt.service.ClientService;
import by.bntu.fitr.povt.service.PetService;
import by.bntu.fitr.povt.service.VisitService;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Log4j2
@Controller
@RequestMapping(path = "/doctor")
public class DoctorController {

    @Setter(onMethod_ = @Autowired)
    PetService petService;

    @Setter(onMethod_ = @Autowired)
    VisitService visitService;

    @Setter(onMethod_ = @Autowired)
    ClientService clientService;

    public String getCurrentUsername() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        return auth.getName();
    }


    @GetMapping(path = "/pet/{id}")
    public String showInfoPetforDoctor(Model model, @PathVariable Integer id) {
        Pet pet = petService.getPetbyId(id);
        log.info("pet is {}", pet);
        model.addAttribute("pet", pet);
        return "pet-page";
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PostMapping(path = "/addDiagnoses/{id}")
    public void addDiagnoses(@PathVariable Integer id, Model model,
                             @RequestParam(name = "diagnoses") String diagnoses) {
        Client client = clientService.getClientByUsername(getCurrentUsername());
        String doctor = client.getFirstName() + " " + client.getSecondName() + "(" + client.getUsername() + ")";
        visitService.doctorAnswer(visitService.getDiseaseHistoryById(id), client, diagnoses);
    }
}
