package by.bntu.fitr.povt.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;

    @Column(name = "doctor_cards", nullable = false)
    private String idCard;
    @OneToOne
    @JoinTable(
            name = "doctor_info",
            joinColumns = @JoinColumn(name = "doctor_id", insertable = false, updatable = false),
            inverseJoinColumns = @JoinColumn(name = "doctor_id", insertable = false, updatable = false))
    private DoctorInfo doctorInfo;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "client_pets",
            joinColumns = @JoinColumn(name = "client_id"),
            inverseJoinColumns = @JoinColumn(name = "pet_id"))
    private List<Pet> pets;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "second_name", nullable = false)
    private String secondName;
    @Column(name = "phone_number", nullable = false)
    private Long phoneNumber;
    @Column(nullable = false)
    private String password;
    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private Role role;
}
