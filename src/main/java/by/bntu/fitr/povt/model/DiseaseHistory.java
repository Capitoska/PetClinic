package by.bntu.fitr.povt.model;

import lombok.Data;

import java.util.Date;

@Data
public class DiseaseHistory {
    private Date date;
    private Pet pet;
    private Client client;
    private Doctor doctor;
    private String description;
}
