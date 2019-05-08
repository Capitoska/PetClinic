package by.bntu.fitr.povt.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "pets")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;

    @Column(nullable = false)
    private Integer gender;
    @Column(nullable = false)
    private String type;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Integer age;
//    private List<DiseaseHistory> medicalCard;
}
