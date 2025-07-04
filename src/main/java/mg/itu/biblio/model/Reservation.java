package mg.itu.biblio.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "reservation")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="date_de_prise")
    private LocalDate datePrise;

    @Column(name = "date_demande")
    private LocalDate dateDemande;

    @Column(name = "date_accept")
    private LocalDate dateAccept;

    @Column(name = "date_refus")
    private LocalDate dateRefus;

    @ManyToOne
    @JoinColumn(name = "id_type", nullable = false)
    private TypeReservation type;

    @ManyToOne
    @JoinColumn(name = "id_utilisateur", nullable = false)
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "id_exemplaire", nullable = false)
    private Exemplaire exemplaire;

}
