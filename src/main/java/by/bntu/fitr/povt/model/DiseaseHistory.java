package by.bntu.fitr.povt.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "disease_histories")
@AllArgsConstructor
public class DiseaseHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;

    @Column(name = "date_visit", nullable = false)
    private LocalDate date;
    @Column(name = "date_answer", nullable = false)
    private LocalDate answerDate;
    @OneToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;
    @OneToOne
    @JoinColumn(name = "sender_id")
    private Client client;
    @OneToOne
    @JoinColumn(name = "doctor_id")
    private Client doctor;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "answer", nullable = false)
    private String answer;

    @Column(name = "doctor_type")
    private Specialty doctorType;

    @Override
    public String toString() {
        return "DiseaseHistory{" +
                "id=" + id +
                '}';
    }

    public DiseaseHistory() {
    }

}
