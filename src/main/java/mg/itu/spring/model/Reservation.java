package mg.itu.spring.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "date_changement", nullable = false)
    private Date dateChangement;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_exemplaire", nullable = false)
    private Exemplaire exemplaire;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_statut", nullable = false)
    private StatutReservation statut;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_adherent", nullable = false)
    private Adherent adherent;

    // Constructeurs
    public Reservation() {
    }

    public Reservation(Date dateChangement, Exemplaire exemplaire, StatutReservation statut, Adherent adherent) {
        this.dateChangement = dateChangement;
        this.exemplaire = exemplaire;
        this.statut = statut;
        this.adherent = adherent;
    }

    // Getters et Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateChangement() {
        return dateChangement;
    }

    public void setDateChangement(Date dateChangement) {
        this.dateChangement = dateChangement;
    }

    public Exemplaire getExemplaire() {
        return exemplaire;
    }

    public void setExemplaire(Exemplaire exemplaire) {
        this.exemplaire = exemplaire;
    }

    public StatutReservation getStatut() {
        return statut;
    }

    public void setStatut(StatutReservation statut) {
        this.statut = statut;
    }

    public Adherent getAdherent() {
        return adherent;
    }

    public void setAdherent(Adherent adherent) {
        this.adherent = adherent;
    }

    // Méthodes utilitaires
    public boolean isActive() {
        return "Actif".equals(statut.getNomStatut());
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", dateChangement=" + dateChangement +
                '}';
    }
}