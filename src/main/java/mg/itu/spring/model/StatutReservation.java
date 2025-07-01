package mg.itu.spring.model;

import jakarta.persistence.*;

@Entity
@Table(name = "statut_reservation")
public class StatutReservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nom_statut", nullable = false, unique = true)
    private String nomStatut;

    // Constructeurs
    public StatutReservation() {
    }

    public StatutReservation(String nomStatut) {
        this.nomStatut = nomStatut;
    }

    // Getters et Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomStatut() {
        return nomStatut;
    }

    public void setNomStatut(String nomStatut) {
        this.nomStatut = nomStatut;
    }

    // Méthode toString()
    @Override
    public String toString() {
        return "StatutReservation{" +
                "id=" + id +
                ", nomStatut='" + nomStatut + '\'' +
                '}';
    }
}