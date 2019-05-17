package by.bntu.fitr.povt.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Data
//@Entity

//@Builder@Table(name = "disease_histories")
public class DiseaseHistory {
    //    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(nullable = false)
    private String id;

    //    @Column(name = "date_visit",nullable = false)
    private LocalDate date;
    //    @Column(name = "date_answer",nullable = false)
    private LocalDate answerDate;
    //    @OneToOne
//    @Column(name = "pet_id",nullable = false)
    private Pet pet;
    //    @OneToOne
//    @Column(name = "sender_id",nullable = false)
    private Client client;
    //    @Column(name = "doctor_id",nullable = false)
    private Doctor doctor;
    //    @Column(name = "description",nullable = false)
    private String description;
    //    @Column(name = "answer",nullable = false)
    private String answer;
}
