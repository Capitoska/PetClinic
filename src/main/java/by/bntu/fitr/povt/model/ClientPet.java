package by.bntu.fitr.povt.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "client_pets")
public class ClientPet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;

    @JoinColumn(name = "client_id", nullable = false)
    @OneToOne
    private Client client;
    @JoinColumn(name = "pet_id", nullable = false)
    @OneToOne
    private Pet pet;
}
