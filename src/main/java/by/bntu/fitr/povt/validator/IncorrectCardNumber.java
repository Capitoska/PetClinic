package by.bntu.fitr.povt.validator;

import javax.validation.Payload;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Target({FIELD, METHOD, CONSTRUCTOR, LOCAL_VARIABLE})
public @interface IncorrectCardNumber {
    String message() default "Такого номера карты не существует.";

    Class<?>[] group() default {};

    Class<? extends Payload>[] payload() default {};
}