package by.bntu.fitr.povt.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NotMixtureUsernameValidator.class)
public @interface NotMixtureUsername {
    String message() default "Нельзя смешивать русские и английские буквы";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
