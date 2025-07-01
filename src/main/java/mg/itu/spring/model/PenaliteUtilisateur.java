package mg.itu.spring.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "penalite_utilisateur")
public class PenaliteUtilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "date_debut", nullable = false)
    private Date dateDebut;

    @Column(name = "date_fin", nullable = false)
    private Date dateFin;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_penalite", nullable = false)
    private Penalite penalite;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_utilisateur", nullable = false)
    private Utilisateur utilisateur;

    // Constructeurs
    public PenaliteUtilisateur() {}

    public PenaliteUtilisateur(Date dateDebut, Date dateFin, Penalite penalite, Utilisateur utilisateur) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.penalite = penalite;
        this.utilisateur = utilisateur;
    }

    // Getters et Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Penalite getPenalite() {
        return penalite;
    }

    public void setPenalite(Penalite penalite) {
        this.penalite = penalite;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    // Méthode utilitaire
    public boolean isActive() {
        Date now = new Date();
        return now.after(dateDebut) && now.before(dateFin);
    }

    @Override
    public String toString() {
        return "PenaliteUtilisateur{" +
                "id=" + id +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                '}';
    }
}