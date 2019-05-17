package by.bntu.fitr.povt.controller;

import by.bntu.fitr.povt.model.*;
import by.bntu.fitr.povt.service.ClientService;
import by.bntu.fitr.povt.service.DoctorService;
import by.bntu.fitr.povt.service.PetService;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@Log4j2
@Controller
@RequestMapping(path = "/user")
public class ClientController {
    @Setter(onMethod_ = @Autowired)
    private ClientService clientService;

    @Setter(onMethod_ = @Autowired)
    private DoctorService doctorService;

    @Setter(onMethod_ = @Autowired)
    private PetService petService;


    public String getCurrentUsername() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        return auth.getName();
    }



    @GetMapping("/person-page")
    public String PersonPage(Model model) {
        log.info(getCurrentUsername());
        if(clientService.getClientByUsername(getCurrentUsername()).getRole().getDisplay().equals("user")){
            Client client = clientService.getClientByUsername(getCurrentUsername());
            log.info(client.getFirstName());
            log.info(client.getPhoneNumber());
            model.addAttribute("firstName", client.getFirstName());
            model.addAttribute("secondName", client.getSecondName());
            model.addAttribute("nickname", client.getUsername());
            model.addAttribute("phone", client.getPhoneNumber());
            model.addAttribute("pets", client.getPets());
            model.addAttribute("specialtyList", Arrays.asList(Specialty.values()));
            return "person-page";
        }
        Doctor doctor = doctorService.getDoctorByUsername(getCurrentUsername());
        model.addAttribute("firstName", doctor.getFirstName());
        model.addAttribute("secondName", doctor.getSecondName());
        model.addAttribute("nickname", doctor.getUsername());
        model.addAttribute("phone", doctor.getPhoneNumber());
        return "doctor-page";


    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PostMapping("/addPet")
    public ResponseEntity addPet(@RequestParam(name = "selectType") String selectType,
                                 @RequestParam(name = "age") String age,
                                 @RequestParam(name = "name") String name,
                                 @RequestParam(name = "gender") String gender) {
        try {
            Client client = clientService.getClientByUsername(getCurrentUsername());
            log.info(selectType);
            log.info(age);
            Pet pet = new Pet();
            int parsedAge = Integer.parseInt(age);

            pet.setAge(parsedAge);
            pet.setName(name);
            pet.setType(selectType);
            pet.setGender(gender);
            petService.createPet(pet);
            clientService.addPet(client, pet);
            clientService.update(client);
            log.info("Good");
        } catch (Exception ex){
            log.debug(ex);
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.noContent().build();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PostMapping("/addPetById")
    public void addPetById(@RequestParam(name = "pet-id") String petId) {
        Client client = clientService.getClientByUsername(getCurrentUsername());
        log.info("Not Good");
        log.info(petId);
        log.info(petService.getPetbyId(Integer.parseInt(petId)));
        log.info(petService.getPetbyId(Integer.parseInt(petId)));
        log.info(petService.getPetbyId(Integer.parseInt(petId)));
        log.info(petService.getPetbyId(Integer.parseInt(petId)));
        clientService.addPet(client, petService.getPetbyId(Integer.parseInt(petId)));
        clientService.update(client);
    }
}
