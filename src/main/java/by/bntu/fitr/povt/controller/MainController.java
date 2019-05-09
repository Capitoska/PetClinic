package by.bntu.fitr.povt.controller;

import by.bntu.fitr.povt.model.Client;
import by.bntu.fitr.povt.service.ClientService;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Log4j2
public class MainController {
    @Setter(onMethod_ = @Autowired)
    private ClientService clientService;

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
        return "sign-up";
    }

    @PostMapping("/reg-owner")
    public @ResponseBody
    String registration(Model model, @RequestParam(name = "firstName", defaultValue = "User") String newfirstName,
                        @RequestParam(name = "secondName", defaultValue = "") String newsecondName,
                        @RequestParam(name = "nickname", defaultValue = "") String newnickname,
                        @RequestParam(name = "telephone", defaultValue = "") String newtelephone,
                        @RequestParam(name = "password", defaultValue = "") String newpassword) {
        log.info("owner");
        Client client = new Client();
        client.setPhoneNumber(Integer.parseInt(newtelephone));
        client.setPassword(newpassword);
        client.setUsername(newnickname);
        client.setSecondName(newsecondName);
        client.setFirstName(newfirstName);
        clientService.createClient(client);
        model.addAttribute("isDoctor", false);
        log.info("test {}", client);
        return "card";
    }

    @GetMapping("/person-page")
    public String PersonPage() {
        return "person-page";
    }

    @GetMapping("/reg-doctor")
    public String registration(Model model) {
        log.info("doctor");
        return "card";
    }
//    @GetMapping("/sign-in")
//    public String signIn(){
//        return "sign-in";
//    }
}
