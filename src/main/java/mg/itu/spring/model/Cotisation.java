package mg.itu.spring.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "cotisation")
public class Cotisation {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "montant_mensuel", nullable = false)
    private Double montantMensuel;
    
    @Column(name = "date_changement", nullable = false)
    private Date dateChangement;
    
    @ManyToOne
    @JoinColumn(name = "id_type_membre", nullable = false)
    private TypeMembre typeMembre;
    
    // Constructeurs
    public Cotisation() {
    }
    
    public Cotisation(Double montantMensuel, Date dateChangement, TypeMembre typeMembre) {
        this.montantMensuel = montantMensuel;
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

    public Double getMontantMensuel() {
        return montantMensuel;
    }

    public void setMontantMensuel(Double montantMensuel) {
        this.montantMensuel = montantMensuel;
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
    
    // Méthode toString()
    @Override
    public String toString() {
        return "Cotisation{" +
                "id=" + id +
                ", montantMensuel=" + montantMensuel +
                ", dateChangement=" + dateChangement +
                ", typeMembre=" + typeMembre +
                '}';
    }
}