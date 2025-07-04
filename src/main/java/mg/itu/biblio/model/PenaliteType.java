package mg.itu.biblio.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "penalite_type")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PenaliteType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer nbjour;

    @ManyToOne
    @JoinColumn(name = "id_type", nullable = false)
    private TypeAdhesion type;  // Assure-toi que TypeAdhesion est bien une entité
}
