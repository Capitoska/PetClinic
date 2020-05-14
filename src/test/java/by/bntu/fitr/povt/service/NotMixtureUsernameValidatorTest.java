package by.bntu.fitr.povt.service;


import by.bntu.fitr.povt.Main;
import by.bntu.fitr.povt.validator.NotMixtureUsername;
import by.bntu.fitr.povt.validator.NotMixtureUsernameValidator;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import static org.junit.jupiter.api.Assertions.*;

@Log4j2
@SpringBootTest(classes = Main.class)
@ExtendWith(SpringExtension.class)
public class NotMixtureUsernameValidatorTest {


    ConstraintValidatorContext validatorContext;
    NotMixtureUsernameValidator notMixtureUsernameValidator = new NotMixtureUsernameValidator();

    /**
     *  username equals null
     */
    @Test
    public void usernameDoesNotExistTrue() {
        assertEquals(notMixtureUsernameValidator.isValid(null, validatorContext), true);
    }


    /**
     * username is valid
     */
    @Test
    public void usernameIsValidTrue(){
        assertEquals(notMixtureUsernameValidator.isValid("Capitoska", validatorContext),true);
    }

    /**
     * username is have English and Russian letters
     */
    @Test
    public void usernameMixtureLettersFalse(){
        assertEquals(notMixtureUsernameValidator.isValid("Capitoskлалала",validatorContext),false);
    }
}
