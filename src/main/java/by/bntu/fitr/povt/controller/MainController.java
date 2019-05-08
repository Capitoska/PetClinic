package by.bntu.fitr.povt.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Log4j2
public class MainController {


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
    /*@GetMapping("/login")
    public String login(
            @RequestParam(name="nickName") String nickName,
            @RequestParam(name="phoneNumber", required=false, defaultValue="не указан") String phoneNumber,
            @RequestParam(name="password") String password,
            @RequestParam(name="exit", required=false) String exit,
            @RequestParam(name="reg", required=false) String reg,
            Model model) {
        model.addAttribute("name", nickName);
        model.addAttribute("phoneNumber", phoneNumber);
        log.info(nickName + " " + phoneNumber + " " + password + " " + exit + " " + reg);
        return "index1";
    }*/

    @GetMapping("/best-doctors")
    public String bestDoctors(Model model) {
        return "card";
    }

    @GetMapping("/")
    public String home(){
        return "about";
    }

    @GetMapping("/about")
    public String about(){
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

    @GetMapping("/sign-in")
    public String signIn(){
        return "sign-in";
    }
}
