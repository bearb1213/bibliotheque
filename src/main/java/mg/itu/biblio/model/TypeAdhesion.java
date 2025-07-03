package mg.itu.biblio.model;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "type_adhesion")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TypeAdhesion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "type")
    private String type;

}
