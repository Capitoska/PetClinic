package by.bntu.fitr.povt.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "doctor_info")
public class DoctorInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;

    @Column(name = "vote_amount")
    private int voteAmount;
    @Column(name = "sum_vote")
    private int sumVote;
    @Column(name = "result")
    private double result;
    @Column(name = "specialty", nullable = false)
    private Specialty specialty;
}
