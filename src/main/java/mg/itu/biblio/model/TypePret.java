package mg.itu.biblio.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "type_pret") // correspond au nom SQL
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TypePret {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "type")
    private String type;
    
}
