package mg.itu.biblio.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;


@Entity
@Table(name = "utilisateur")
@Data
@NoArgsConstructor
@AllArgsConstructor	
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "nom")
    private String nom;
    
    @Column(name = "email")
    private String email;

    @Column(name = "mot_de_passe")
    private String motDePasse;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name ="id_type")
    private UtilisateurType utilisateurType;

    @OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL, orphanRemoval = true , fetch=FetchType.LAZY)
    private List<Adhesion> adhesions;

    // public static int calculerAge(LocalDate dateNaissance) {
    //     if (dateNaissance == null) return 0;
    //     return Period.between(dateNaissance, LocalDate.now()).getYears();
    // }

}
