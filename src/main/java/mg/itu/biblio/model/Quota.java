package mg.itu.biblio.model;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "quota")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Quota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "quota")
    private Integer quota;
    
    @Column(name = "action")
    private String action;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_type")
    private TypeAdhesion typeAdhesion;
    

}
