package mg.itu.spring.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "quota")
public class Quota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Integer valeur;

    @Column(name = "date_changement", nullable = false)
    private Date dateChangement;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_type_membre", nullable = false)
    private TypeMembre typeMembre;

    // Constructeurs
    public Quota() {
    }

    public Quota(Integer valeur, Date dateChangement, TypeMembre typeMembre) {
        this.valeur = valeur;
        this.dateChangement = dateChangement;
        this.typeMembre = typeMembre;
    }

    // Getters et Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getValeur() {
        return valeur;
    }

    public void setValeur(Integer valeur) {
        this.valeur = valeur;
    }

    public Date getDateChangement() {
        return dateChangement;
    }

    public void setDateChangement(Date dateChangement) {
        this.dateChangement = dateChangement;
    }

    public TypeMembre getTypeMembre() {
        return typeMembre;
    }

    public void setTypeMembre(TypeMembre typeMembre) {
        this.typeMembre = typeMembre;
    }

    // Méthode utilitaire pour vérifier si le quota est actif (le plus récent pour son type)
    public boolean isCurrent() {
        // Implémentation dépendra de la logique métier
        return true;
    }

    @Override
    public String toString() {
        return "Quota{" +
                "id=" + id +
                ", valeur=" + valeur +
                ", dateChangement=" + dateChangement +
                '}';
    }
}