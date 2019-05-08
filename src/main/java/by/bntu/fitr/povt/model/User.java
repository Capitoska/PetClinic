package by.bntu.fitr.povt.model;

import lombok.Data;

import javax.persistence.*;

@Data
@MappedSuperclass
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "second_name", nullable = false)
    private String secondName;
    @Column(name = "phone_number", nullable = false)
    private Integer phoneNumber;
    @Column(nullable = false)
    private String password;
}
