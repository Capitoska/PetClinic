package by.bntu.fitr.povt.dto;

import by.bntu.fitr.povt.validator.NotMixtureUsername;
import by.bntu.fitr.povt.validator.UniqueName;
import lombok.Data;

import javax.validation.constraints.Size;

@Data
public class SignUpUserDto {
    @Size(min = 2, max = 20, message = "Ваш пароль должен быть длиной от 2 до 20 значений!")
    private String firstName;
    @Size(min = 2, max = 20, message = "Ваш пароль должен быть длиной от 2 до 20 значений!")
    private String secondName;
    @NotMixtureUsername
    @Size(min = 6, max = 20, message = "Ваш пароль должен быть длиной от 6 до 20 значений!")
    private String password;
    private String idCard;
    private String specialistic;
    private String phone;
    @NotMixtureUsername
    @UniqueName(message = "Этот никнейм уже существуетю")
    private String nickName;
}

