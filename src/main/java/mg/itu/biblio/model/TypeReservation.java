package mg.itu.biblio.model;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "type_reservation")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TypeReservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "type")
    private String type;

}
