package by.bntu.fitr.povt.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "pets")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "type",nullable = false)
    private String type;
    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "age",nullable = false)
    private Integer age;

//    @OneToMany
//    private List<DiseaseHistory> medicalCard;

}
