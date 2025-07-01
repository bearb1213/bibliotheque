package mg.itu.spring.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pret")
public class Pret {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "date_debut", nullable = false)
    private Date dateDebut;

    @Column(name = "date_fin", nullable = false)
    private Date dateFin;

    @ManyToOne
    @JoinColumn(name = "id_exemplaire", nullable = false)
    private Exemplaire exemplaire;

    @ManyToOne
    @JoinColumn(name = "id_type_pret")
    private TypePret typePret;

    @ManyToOne
    @JoinColumn(name = "id_adherent", nullable = false)
    private Adherent adherent;

    // Constructeurs
    public Pret() {
    }

    public Pret(Date dateDebut, Date dateFin, Exemplaire exemplaire, TypePret typePret, Adherent adherent) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.exemplaire = exemplaire;
        this.typePret = typePret;
        this.adherent = adherent;
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

    public Exemplaire getExemplaire() {
        return exemplaire;
    }

    public void setExemplaire(Exemplaire exemplaire) {
        this.exemplaire = exemplaire;
    }

    public TypePret getTypePret() {
        return typePret;
    }

    public void setTypePret(TypePret typePret) {
        this.typePret = typePret;
    }

    public Adherent getAdherent() {
        return adherent;
    }

    public void setAdherent(Adherent adherent) {
        this.adherent = adherent;
    }

    // Méthodes utilitaires
    public boolean isEnCours() {
        Date now = new Date();
        return now.after(dateDebut) && now.before(dateFin);
    }

    public boolean isRetard() {
        return new Date().after(dateFin);
    }

    @Override
    public String toString() {
        return "Pret{" +
                "id=" + id +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                '}';
    }
}