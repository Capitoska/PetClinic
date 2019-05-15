package by.bntu.fitr.povt.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Data
//@Entity
public class Doctor extends User {
    private int idCard;
    private int voteAmount;
    private int sumVote;
    private double result;
    private Specialty specialty;
}
