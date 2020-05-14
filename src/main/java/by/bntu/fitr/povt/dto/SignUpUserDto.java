package by.bntu.fitr.povt.dto;

import by.bntu.fitr.povt.validator.IncorrectCardNumber;
import by.bntu.fitr.povt.validator.UniqueName;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Data
public class SignUpUserDto {
    @NotEmpty
    @Size(min = 3, max = 20, message = "Ваш пароль должен быть длиной от 2 до 20 значений!")
    private String firstName;

    @Size(min = 3, max = 20, message = "Ваш пароль должен быть длиной от 2 до 20 значений!")
    private String secondName;
    @Size(min = 3, max = 20, message = "Ваш пароль должен быть длиной от 3 до 20 значений!")
    private String password;

    @IncorrectCardNumber
    private String idCard;

    private String specialistic;

    @Positive
    private Long phone;
    @Size(min = 3, max = 15, message = "Ваш Nickname должен быть длиной от 6 до 10 значений!")
    @UniqueName(message = "Этот никнейм уже существует")
    private String nickName;
}

