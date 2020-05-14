package by.bntu.fitr.povt.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Builder
@Table(name = "doctor_info")
@NoArgsConstructor
@AllArgsConstructor
public class DoctorInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id")
    private Client client;

    @Column(name = "vote_amount")
    private int voteAmount;
    @Column(name = "sum_vote")
    private int sumVote;
    @Column(name = "result")
    private double result;
    @Column(name = "specialty", nullable = false)
    private Specialty specialty;
}
