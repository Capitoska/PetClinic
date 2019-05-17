package by.bntu.fitr.povt.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "clients")
public class Doctor extends User {
    @Column(name = "doctor_cards", nullable = false)
    private String idCard;
    @OneToOne
    @JoinTable(
            name = "doctor_info",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "id"))
    DoctorInfo doctorInfo;
}
