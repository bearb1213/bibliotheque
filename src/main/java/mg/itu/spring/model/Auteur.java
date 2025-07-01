package mg.itu.spring.model;

import jakarta.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "auteur")
public class Auteur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String nom;

    @Column(name = "first_name")
    private String prenom;

    private Date birthday;

    private String nationality;

    @OneToMany(mappedBy = "auteur", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Livre> livres;

    public Auteur() {}  

    public Auteur(String nom, String prenom, Date birthday, String nationality) {
        this.nom = nom;
        this.prenom = prenom;
        this.birthday = birthday;
        this.nationality = nationality;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public List<Livre> getLivres() {
        return livres;
    }

    public void setLivres(List<Livre> livres) {
        this.livres = livres;
    }   
}
