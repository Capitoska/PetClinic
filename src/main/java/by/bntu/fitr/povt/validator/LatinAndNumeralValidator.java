package by.bntu.fitr.povt.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class LatinAndNumeralValidator implements ConstraintValidator<LatinAndNumeral,String> {
    private Pattern eng = Pattern.compile("[^a-zA-Z]");
    private Pattern numeral = Pattern.compile("[^0-9]");
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(eng.matcher(value).find() && numeral.matcher(value).find())
            return false;
        return true;
    }
}
