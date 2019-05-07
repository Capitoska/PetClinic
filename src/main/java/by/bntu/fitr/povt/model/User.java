package by.bntu.fitr.povt.model;

import lombok.Data;
import lombok.Setter;

@Data
public class User {
    private int phoneNumber;
    private Integer id;
    private String name;
    private String password;
    private String gender;

}
