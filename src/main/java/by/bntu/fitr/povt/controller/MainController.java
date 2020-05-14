package by.bntu.fitr.povt.controller;

import by.bntu.fitr.povt.dto.SignUpUserDto;
import by.bntu.fitr.povt.dto.converter.SignInConverter;
import by.bntu.fitr.povt.dto.converter.SignUpConverter;
import by.bntu.fitr.povt.model.Client;
import by.bntu.fitr.povt.model.Specialty;
import by.bntu.fitr.povt.service.ClientService;
import by.bntu.fitr.povt.service.DoctorService;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.Arrays;

@Controller
@Log4j2
public class MainController {
    @Setter(onMethod_ = @Autowired)
    private ClientService clientService;
    @Setter(onMethod_ = @Autowired)
    private DoctorService doctorService;

    @Autowired
    private SignInConverter signInConverter;

    @Autowired
    private SignUpConverter signUpConverter;


    @GetMapping("/greeting/1") // Когда мы обращаемся по этому адресу
    public String greeting(
            @RequestParam(name = "name", required = false, defaultValue = "World") String name,
            @RequestParam(value = "value", required = false, defaultValue = "Value") String value, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("value", value);
        return "greeting1"; // Выводит такая страничка
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


    /**
     * регистрация пользователя.
     */
    @GetMapping("/sign-up")
    public String signUp(Model model, @RequestParam(name = "user") String user) {
        model.addAttribute("signUpUser", new SignUpUserDto());
        if (user.equals("doctor")) {
            model.addAttribute("specialtyList", Arrays.asList(Specialty.values()));
            model.addAttribute("user", "doctor");
            model.addAttribute("isDoctor", user.equals("doctor"));
            return "sign-up";
        }

        model.addAttribute("user", "owner");
        return "sign-up";
    }

    @GetMapping("/tesst")
    public String testController(Model model, @RequestParam(name = "testiruy") String say) {
        log.info("TEST METHOD WORKED");
        log.info(say);
        return "about";
    }

    @GetMapping("/registration")
    public String registration(Model model, @RequestParam(name = "user") String user) {
        Boolean isDoctor = user.equals("doctor");
        model.addAttribute("user", user);
        model.addAttribute("signUpUser", new SignUpUserDto());
        return "sign-up";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute(name = "signUpUser") @Valid SignUpUserDto signUpUserDto,
                               BindingResult errors, @RequestParam(name = "user") String user,
                               Model model) {
        Boolean isDoctor = user.equals("doctor");

        if (errors.hasErrors()) {
            model.addAttribute("user", user);
            return "sign-up";
        }

        if (isDoctor) {
            Client client = signUpConverter.toDoctor(signUpUserDto);
            doctorService.createDoctor(client);
        } else {
            Client client = signUpConverter.toOwner(signUpUserDto);
            clientService.createClient(client);
        }
        model.addAttribute("answer", "Вы успешно зарегистрировались! Выполните вход.");
        return "success-reg";
    }


    // Стояло ResponseBody ....
//    @PostMapping("/reg-owner")
//    public String registration(@RequestParam(name = "firstName", defaultValue = "User") String newfirstName,
//                               @RequestParam(name = "secondName", defaultValue = "") String newsecondName,
//                               @RequestParam(name = "nickname", defaultValue = "") String newnickname,
//                               @RequestParam(name = "telephone", defaultValue = "") String newtelephone,
//                               @RequestParam(name = "password", defaultValue = "") String newpassword,
//                               Model model) {
//        log.info("owner");
//        Client client = new Client();
//        client.setPhoneNumber(Long.parseLong(newtelephone));
//        client.setPassword(newpassword);
//        client.setUsername(newnickname);
//        client.setSecondName(newsecondName);
//        client.setFirstName(newfirstName);
//        client.setRole(Role.USER);
//        clientService.createClient(client);
//        model.addAttribute("isDoctor", false);
//        log.info("test {}", client);
//        model.addAttribute("answer","Вы успешно зарегистрировались!");
//        return "success-reg";
//    }
//
//    @PostMapping("/reg-doctor")
//    public String registration(@RequestParam(name = "firstName", defaultValue = "User") String newfirstName,
//                               @RequestParam(name = "secondName", defaultValue = "") String newsecondName,
//                               @RequestParam(name = "nickname", defaultValue = "") String newnickname,
//                               @RequestParam(name = "telephone", defaultValue = "") String newtelephone,
//                               @RequestParam(name = "password", defaultValue = "") String newpassword,
//                               @RequestParam(name = "specialty", defaultValue = "") String newspecialty,
//                               @RequestParam(name = "idcard", defaultValue = "") String newidcard,
//                               Model model) {
//        log.info("Doctor registration!!!");
//        Client client = new Client();
//        client.setFirstName(newfirstName);
//        client.setSecondName(newsecondName);
//        client.setUsername(newnickname);
//        client.setPhoneNumber(Long.parseLong(newtelephone));
//        client.setPassword(newpassword);
//        DoctorInfo doctorInfo = new DoctorInfo();
//        client.setDoctorInfo(doctorInfo);
//        client.getDoctorInfo().setSpecialty(Specialty.valueOf(newspecialty));
//        client.setIdCard(newidcard);
//        client.setRole(Role.DOCTOR);
//        log.info("All good");
//        if (doctorService.createDoctor(client)) {
//            model.addAttribute("answer", "Вы успешно зарегистрировались! Добро пожаловать" + client.getFirstName() + " " + client.getSecondName());
//        } else {
//            model.addAttribute("answer", "Ошибка регистрации доктора. Если у вы доктор и у вас возникли проблемы регистрации, свяжитесь с начальством!");
//        }
//        return "success-reg";
//    }
}