package mg.itu.spring.model;

import jakarta.persistence.*;

@Entity
@Table(name = "bibliothecaire")
public class Bibliothecaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "id_utilisateur", nullable = false)
    private Utilisateur utilisateur;

    // Constructeurs
    public Bibliothecaire() {
    }

    public Bibliothecaire(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    // Getters et Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    // Méthode toString()
    @Override
    public String toString() {
        return "Bibliothecaire{" +
                "id=" + id +
                ", utilisateur=" + utilisateur +
                '}';
    }
}