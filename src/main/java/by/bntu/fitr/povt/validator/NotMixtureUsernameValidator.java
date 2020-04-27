package by.bntu.fitr.povt.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class NotMixtureUsernameValidator implements ConstraintValidator<NotMixtureUsername, String> {
    private Pattern eng = Pattern.compile("[a-zA-Z]");
    private Pattern rus = Pattern.compile("[а-яА-Я]");

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        if (username == null) {
            return true;
        }
        if (eng.matcher(username).find() && rus.matcher(username).find()) {
            return false;
        }
        return true;
    }
}
