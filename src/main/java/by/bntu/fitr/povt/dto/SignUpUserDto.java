package by.bntu.fitr.povt.dto;

import by.bntu.fitr.povt.validator.IncorrectCardNumber;
import by.bntu.fitr.povt.validator.LatinAndNumeral;
import by.bntu.fitr.povt.validator.UniqueName;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Data
public class SignUpUserDto {
    @NotEmpty
    @LatinAndNumeral
    @Size(min = 3, max = 20, message = "Ваш пароль должен быть длиной от 2 до 20 значений!")
    private String firstName;

    @Size(min = 3, max = 20, message = "Ваш пароль должен быть длиной от 2 до 20 значений!")
    private String secondName;

    @LatinAndNumeral
    @Size(min = 3, max = 20, message = "Ваш пароль должен быть длиной от 6 до 20 значений!")
    private String password;

    @IncorrectCardNumber
    private String idCard;

    @NotNull
    @NotEmpty
    private String specialistic;

    @Positive
    private Long phone;

    @Size(min = 6, max = 10, message = "Ваш пароль должен быть длиной от 6 до 10 значений!")
    @UniqueName(message = "Этот никнейм уже существуетю")
    private String nickName;
}

