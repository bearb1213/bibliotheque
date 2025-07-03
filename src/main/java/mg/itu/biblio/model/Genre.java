package mg.itu.biblio.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "genre")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "genre")
    private String genre;
    
}
