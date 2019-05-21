package by.bntu.fitr.povt.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

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

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "pet_id")
    private List<DiseaseHistory> medicalCard;

}
