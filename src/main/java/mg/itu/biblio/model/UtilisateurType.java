package mg.itu.biblio.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "utilisateur_type")
@Data
@NoArgsConstructor
@AllArgsConstructor	
public class UtilisateurType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "type")
    private String type;

    
    
}
