package by.bntu.fitr.povt.validator;

import by.bntu.fitr.povt.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueName,String> {

    private ClientService clientService;


    public UniqueUsernameValidator(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        if(username == null){
            return true;
        }

        return clientService.getClientByUsername(username) == null;
    }
}
