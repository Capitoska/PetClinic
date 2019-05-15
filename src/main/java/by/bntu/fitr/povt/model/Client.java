package by.bntu.fitr.povt.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "clients")
public class Client extends User {

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "client_pets",
            joinColumns = @JoinColumn(name = "client_id"),
            inverseJoinColumns = @JoinColumn(name = "pet_id"))
    private List<Pet> pets;


    public List<Pet> getPets() {
        return pets;
    }
}
