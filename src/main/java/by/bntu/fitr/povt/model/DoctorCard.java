package by.bntu.fitr.povt.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "unregistered_doctor_cards")
public class DoctorCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;

    @Column(name = "name_card")
    String card;

}
