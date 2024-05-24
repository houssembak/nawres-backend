package net.javaguides.springbootbackend.model;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

@Data
@Entity
@Table(name = "demandes_stagiaires")
public class DemandeStagiaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String nom;


    private String prenom;


    private String email;


    private String telephone;

    @Temporal(TemporalType.DATE)
    private Date debutStage;

    @CreatedDate
    @Temporal(TemporalType.DATE)
    private Date finStage;


    private String filiere;


    private String centre; // rendre le champ centre nullable

    // Getters and setters
}
