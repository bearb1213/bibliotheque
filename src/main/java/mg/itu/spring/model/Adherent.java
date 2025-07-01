package mg.itu.spring.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "adherent")
public class Adherent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "date_debut", nullable = false)
    private Date dateDebut;

    @Column(name = "date_fin", nullable = false)
    private Date dateFin;

    @ManyToOne
    @JoinColumn(name = "id_utilisateur", nullable = false)
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "id_type_membre", nullable = false)
    private TypeMembre typeMembre;

    @OneToMany(mappedBy = "adherent", 
               cascade = CascadeType.ALL, 
               orphanRemoval = true,
               fetch = FetchType.LAZY)
    private List<Pret> prets = new ArrayList<>();


    // Constructeurs
    public Adherent() {
    }

    public Adherent(Date dateDebut, Date dateFin, Utilisateur utilisateur, TypeMembre typeMembre) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.utilisateur = utilisateur;
        this.typeMembre = typeMembre;
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

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public TypeMembre getTypeMembre() {
        return typeMembre;
    }

    public void setTypeMembre(TypeMembre typeMembre) {
        this.typeMembre = typeMembre;
    }

    // Méthode utilitaire pour vérifier si l'adhésion est valide
    public boolean isAdhesionValide() {
        Date now = new Date();
        return now.after(dateDebut) && now.before(dateFin);
    }

    public void addPret(Pret pret) {
        prets.add(pret);
        pret.setExemplaire(this);
    }

    public void removePret(Pret pret) {
        prets.remove(pret);
        pret.setExemplaire(null);
    }


    // Méthode toString()
    @Override
    public String toString() {
        return "Adherent{" +
                "id=" + id +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", utilisateur=" + utilisateur +
                ", typeMembre=" + typeMembre +
                '}';
    }
}