package mg.itu.biblio.model;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "adhesion")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Adhesion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "date_debut")
    private LocalDate dateDebut;

    @Column(name = "date_fin")
    private LocalDate dateFin;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_type")
    private TypeAdhesion typeAdhesion;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_utilisateur")
    private Utilisateur utilisateur;
    
    
}
