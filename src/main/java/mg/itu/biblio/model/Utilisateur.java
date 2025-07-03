package mg.itu.biblio.model;

import jakarta.persistence.*;
import lombok.*;


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

    

}
