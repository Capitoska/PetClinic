package by.bntu.fitr.povt.service;

import by.bntu.fitr.povt.Main;
import by.bntu.fitr.povt.validator.NotMixtureUsernameValidator;
import by.bntu.fitr.povt.validator.UniqueUsernameValidator;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.validation.ConstraintValidatorContext;

import static org.junit.jupiter.api.Assertions.*;
@Log4j2
@SpringBootTest(classes = Main.class)
@ExtendWith(SpringExtension.class)
public class UniqueUsernameValidatorTest {

    ClientService clientService;

    ConstraintValidatorContext validatorContext;
    UniqueUsernameValidator uniqueUsernameValidator = new UniqueUsernameValidator(clientService);

    @Test
    public void UniqueUsernameTrue(){
        assertTrue(uniqueUsernameValidator.isValid("UniqueValidUsername",validatorContext));
    }

    @Test
    public void NotUniqueUsernameFalse(){
        assertFalse(uniqueUsernameValidator.isValid("Capitoska",validatorContext));
    }
}