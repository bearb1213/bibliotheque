package mg.itu.spring.model;

import jakarta.persistence.*;

@Entity
@Table(name = "penalite")
public class Penalite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nb_jours_retard", nullable = false)
    private Integer nbJoursRetard;

    @Column(name = "penalite_par_jour", nullable = false)
    private Integer penaliteParJour;

    // Constructeurs
    public Penalite() {
    }

    public Penalite(Integer nbJoursRetard, Integer penaliteParJour) {
        this.nbJoursRetard = nbJoursRetard;
        this.penaliteParJour = penaliteParJour;
    }

    // Getters et Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNbJoursRetard() {
        return nbJoursRetard;
    }

    public void setNbJoursRetard(Integer nbJoursRetard) {
        this.nbJoursRetard = nbJoursRetard;
    }

    public Integer getPenaliteParJour() {
        return penaliteParJour;
    }

    public void setPenaliteParJour(Integer penaliteParJour) {
        this.penaliteParJour = penaliteParJour;
    }

    // Méthode utilitaire pour calculer la pénalité totale
    public Integer calculerPenaliteTotale() {
        return nbJoursRetard * penaliteParJour;
    }

    // Méthode toString()
    @Override
    public String toString() {
        return "Penalite{" +
                "id=" + id +
                ", nbJoursRetard=" + nbJoursRetard +
                ", penaliteParJour=" + penaliteParJour +
                '}';
    }
}