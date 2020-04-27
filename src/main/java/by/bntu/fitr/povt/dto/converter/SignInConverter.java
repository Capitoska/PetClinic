package by.bntu.fitr.povt.dto.converter;

import by.bntu.fitr.povt.dto.SignInDto;
import by.bntu.fitr.povt.model.Client;
import by.bntu.fitr.povt.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SignInConverter {

    @Autowired
    ClientService clientService;

    public Client toUserEntity(SignInDto signInDto){
        return clientService.getClientByUsernameAndPassword(signInDto.getUsername(),signInDto.getPassword());
    }
}
