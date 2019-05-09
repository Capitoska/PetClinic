package by.bntu.fitr.povt.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Doctor extends User {
    private int idCard;
    private Rating rating;
}
