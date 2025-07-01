package mg.itu.spring.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "paiement")
public class Paiement {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(nullable = false)
    private Double montant;
    
    @Column(name = "date_paiement", nullable = false)
    private Date datePaiement;
    
    @ManyToOne
    @JoinColumn(name = "id_utilisateur", nullable = false)
    private Utilisateur utilisateur;
    
    @ManyToOne
    @JoinColumn(name = "id_type_membre", nullable = false)
    private TypeMembre typeMembre;
    
    // Constructeurs
    public Paiement() {
    }
    
    public Paiement(Double montant, Date datePaiement, Utilisateur utilisateur, TypeMembre typeMembre) {
        this.montant = montant;
        this.datePaiement = datePaiement;
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

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public Date getDatePaiement() {
        return datePaiement;
    }

    public void setDatePaiement(Date datePaiement) {
        this.datePaiement = datePaiement;
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
    
    // Méthode toString()
    @Override
    public String toString() {
        return "Paiement{" +
                "id=" + id +
                ", montant=" + montant +
                ", datePaiement=" + datePaiement +
                ", utilisateur=" + utilisateur +
                ", typeMembre=" + typeMembre +
                '}';
    }
}