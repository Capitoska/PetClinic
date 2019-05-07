package by.bntu.fitr.povt.model;

import lombok.Data;

@Data
public class Client extends User {
    private Animal[] animals;
    private Integer score;
}
