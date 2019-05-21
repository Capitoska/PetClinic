package by.bntu.fitr.povt.controller;

import by.bntu.fitr.povt.model.*;
import by.bntu.fitr.povt.service.ClientService;
import by.bntu.fitr.povt.service.DoctorService;
import by.bntu.fitr.povt.service.PetService;
import by.bntu.fitr.povt.service.VisitService;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

    @Setter(onMethod_ = @Autowired)
    private VisitService visitService;

    public String getCurrentUsername() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        return auth.getName();
    }

    // TODO: 5/17/2019 Hardcode, replace in future
    @GetMapping("/show-pet-information")
    public String showPetInformation(){
        return "pet-page";
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PostMapping("/delPetById")
    public ResponseEntity delPetById(@RequestParam(name = "id-pet") Integer idPet,
            Model model){
        log.info("Use method Delete Pet By Id");
        log.info(getCurrentUsername());
        log.info(idPet);
        clientService.removePetById(clientService.getClientByUsername(getCurrentUsername()),idPet);
        return ResponseEntity.noContent().build();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PostMapping("/addAnAppointment")
    public ResponseEntity addAnAppointment(@RequestParam(name = "description") String description,
                                           @RequestParam(name = "IDPet")Integer petId,
                                           @RequestParam(name = "date")String date,
                                           @RequestParam(name = "typeOfDoctor") Specialty specialty,
                                           Model model){
        log.info("Добавляем данные...");
        log.info(date);
        Client client = clientService.getClientByUsername(getCurrentUsername());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate= LocalDate.parse(date,formatter);
        visitService.addVisit(client,petService.getPetbyId(petId),description,localDate,specialty);
        return ResponseEntity.noContent().build();
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
        Client client = doctorService.getDoctorByUsername(getCurrentUsername());
        model.addAttribute("firstName", client.getFirstName());
        model.addAttribute("secondName", client.getSecondName());
        model.addAttribute("nickname", client.getUsername());
        model.addAttribute("phone", client.getPhoneNumber());
        model.addAttribute("specialty", client.getDoctorInfo().getSpecialty().getDisplayName());
        model.addAttribute("diseaseHistories", doctorService.getAllDiseaseBySpecialty(client.getDoctorInfo().getSpecialty()));
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
