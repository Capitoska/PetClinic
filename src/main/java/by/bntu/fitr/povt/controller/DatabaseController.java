package by.bntu.fitr.povt.controller;

import by.bntu.fitr.povt.model.Client;
import by.bntu.fitr.povt.service.ClientService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/data")
public class DatabaseController {

    @Setter(onMethod_ = @Autowired)
    private ClientService clientService;

    //http://localhost:8080/data/add?newFirstName=test&newSecondName=test2&newHandle=345
    @GetMapping("/add")
    public @ResponseBody
    String add(@RequestParam String newFirstName,
               @RequestParam String newSecondName,
               @RequestParam String newUsername,
               @RequestParam String newPassword,
               @RequestParam String newPhoneNumber
    ) {
        Client client = new Client();
        client.setUsername(newUsername);
        client.setFirstName(newFirstName);
        client.setSecondName(newSecondName);
        client.setPassword(newPassword);
        client.setPhoneNumber(Long.parseLong(newPhoneNumber));
        clientService.createClient(client);
        return "Saved";
    }

    @GetMapping("/all")
    public @ResponseBody
    Iterable<Client> all() {
        return clientService.getAll();
    }
}
