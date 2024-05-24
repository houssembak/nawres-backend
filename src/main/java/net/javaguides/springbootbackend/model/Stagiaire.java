package net.javaguides.springbootbackend.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "stagiaire")
@Data
public class Stagiaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String email;

    private String phone;

    private String password;

}

