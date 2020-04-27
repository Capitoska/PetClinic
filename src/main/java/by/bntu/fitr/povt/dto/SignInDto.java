package by.bntu.fitr.povt.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class SignInDto {

    @NotBlank(message = "Это поле должно быть заполнено")
    private String username;
    @NotBlank(message = "Это поле должно быть заполнено")
    private String password;
}
