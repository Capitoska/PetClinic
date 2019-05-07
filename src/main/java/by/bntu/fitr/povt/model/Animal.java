package by.bntu.fitr.povt.model;

import lombok.Data;

@Data
public class Animal {
    private Integer id;
    private String gender;
    private String animalType;
    private String name;
    private Integer age;
    private Client[] owners;
    private DiseaseHistory[] medicalCard;
}
