package by.bntu.fitr.povt.controller;

import by.bntu.fitr.povt.model.*;
import by.bntu.fitr.povt.service.ClientService;
import by.bntu.fitr.povt.service.DoctorService;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;

@Controller
@Log4j2
public class MainController {
    @Setter(onMethod_ = @Autowired)
    private ClientService clientService;
    @Setter(onMethod_ = @Autowired)
    private DoctorService doctorService;


    @GetMapping("/greeting/1") // Когда мы обращаемся по этому адресу
    public String greeting(
            @RequestParam(name = "name", required = false, defaultValue = "World") String name,
            @RequestParam(value = "value", required = false, defaultValue = "Value") String value, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("value", value);
        return "greeting1"; // Выводит такая страничка
    }


    @GetMapping("/greeting") // Когда мы обращаемся по этому адресу
    public String greeting2(@RequestParam(name = "name", required = false, defaultValue = "12333") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting"; // Выводит такая страничка
    }

    @GetMapping("/best-doctors")
    public String bestDoctors() {
        return "card";
    }

    @GetMapping("/")
    public String home() {
        return "about";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }


    @GetMapping("/sign-up")
    public String signUp(
            @RequestParam(name = "doctor", required = false) String doctor,
            @RequestParam(name = "owner", required = false) String owner,
            Model model) {

        boolean isDoctor = doctor != null;
        log.info(isDoctor);
        model.addAttribute("isDoctor", isDoctor);
        model.addAttribute("specialtyList", Arrays.asList(Specialty.values()));
        return "sign-up";
    }
 // Стояло ResponseBody ....
    @PostMapping("/reg-owner")
    public String registration(@RequestParam(name = "firstName", defaultValue = "User") String newfirstName,
                        @RequestParam(name = "secondName", defaultValue = "") String newsecondName,
                        @RequestParam(name = "nickname", defaultValue = "") String newnickname,
                        @RequestParam(name = "telephone", defaultValue = "") String newtelephone,
                        @RequestParam(name = "password", defaultValue = "") String newpassword,
                        Model model) {
        log.info("owner");
        Client client = new Client();
        client.setPhoneNumber(Long.parseLong(newtelephone));
        client.setPassword(newpassword);
        client.setUsername(newnickname);
        client.setSecondName(newsecondName);
        client.setFirstName(newfirstName);
        client.setRole(Role.USER);
        clientService.createClient(client);
        model.addAttribute("isDoctor", false);
        log.info("test {}", client);
        return "success-reg";
    }

    @PostMapping("/reg-doctor")
    public String registration(@RequestParam(name = "firstName", defaultValue = "User") String newfirstName,
                               @RequestParam(name = "secondName", defaultValue = "") String newsecondName,
                               @RequestParam(name = "nickname", defaultValue = "") String newnickname,
                               @RequestParam(name = "telephone", defaultValue = "") String newtelephone,
                               @RequestParam(name = "password", defaultValue = "") String newpassword,
                               @RequestParam(name = "specialty", defaultValue = "") String newspecialty,
                               @RequestParam(name = "idcard", defaultValue = "") String newidcard,
                               Model model) {
        log.info("Doctor registration!!!");
        Doctor doctor = new Doctor();
        doctor.setFirstName(newfirstName);
        doctor.setSecondName(newsecondName);
        doctor.setUsername(newnickname);
        doctor.setPhoneNumber(Long.parseLong(newtelephone));
        doctor.setPassword(newpassword);
        DoctorInfo doctorInfo = new DoctorInfo();
        doctor.setDoctorInfo(doctorInfo);
        doctor.getDoctorInfo().setSpecialty(Specialty.valueOf(newspecialty));
        doctor.setIdCard(newidcard);
        doctor.setRole(Role.DOCTOR);
        log.info("All good");
        doctorService.createDoctor(doctor, doctorInfo);
        return "success-reg";
    }
}