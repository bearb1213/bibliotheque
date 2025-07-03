package mg.itu.biblio.model;


import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "auteur")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Auteur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "nom")
    private String nom;
    
}
