package by.bntu.fitr.povt.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Target({METHOD, FIELD, CONSTRUCTOR, ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueUsernameValidator.class)
public @interface UniqueName {
    String message() default "Данное имя уже занято.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
