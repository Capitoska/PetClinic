package by.bntu.fitr.povt.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@Table(name = "pets")
public class Pet {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return Objects.equals(id, pet.id) &&
                Objects.equals(gender, pet.gender) &&
                Objects.equals(type, pet.type) &&
                Objects.equals(name, pet.name) &&
                Objects.equals(age, pet.age) &&
                Objects.equals(medicalCard, pet.medicalCard);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, gender, type, name, age, medicalCard);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Integer id;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "type", nullable = false)
    private String type;
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "age", nullable = false)
    private Integer age;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "pet_id")
    private List<DiseaseHistory> medicalCard;

}
