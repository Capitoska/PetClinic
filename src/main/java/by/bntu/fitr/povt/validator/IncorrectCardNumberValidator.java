package by.bntu.fitr.povt.validator;

import by.bntu.fitr.povt.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IncorrectCardNumberValidator implements ConstraintValidator<IncorrectCardNumber, String> {

    @Autowired
    DoctorService doctorService;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return doctorService.isDoctorCardByName(value);
    }
}
