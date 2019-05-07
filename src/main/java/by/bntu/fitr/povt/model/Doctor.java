package by.bntu.fitr.povt.model;

import lombok.Data;

@Data
public class Doctor extends User {
    private int idCard;
    private Rating rating;
}
