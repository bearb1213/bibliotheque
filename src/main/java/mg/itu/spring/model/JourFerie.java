package mg.itu.spring.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "jour_ferie")
public class JourFerie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "date_jour_ferie", nullable = false, unique = true)
    private Date dateJourFerie;

    // Constructeurs
    public JourFerie() {
    }

    public JourFerie(Date dateJourFerie) {
        this.dateJourFerie = dateJourFerie;
    }

    // Getters et Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateJourFerie() {
        return dateJourFerie;
    }

    public void setDateJourFerie(Date dateJourFerie) {
        this.dateJourFerie = dateJourFerie;
    }

    // Méthode toString()
    @Override
    public String toString() {
        return "JourFerie{" +
                "id=" + id +
                ", dateJourFerie=" + dateJourFerie +
                '}';
    }
}