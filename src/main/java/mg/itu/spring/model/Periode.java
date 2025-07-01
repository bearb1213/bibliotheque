package mg.itu.spring.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "periode")
public class Periode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nom_periode")
    private String nomPeriode;

    @Column(name = "annee_debut")
    private Integer anneeDebut;

    @Column(name = "annee_fin")
    private Integer anneeFin;

    
    @OneToMany(mappedBy = "auteur", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Livre> livres;
    // Constructeurs
    public Periode() {}

    public Periode(String nomPeriode, Integer anneeDebut, Integer anneeFin) {
        this.nomPeriode = nomPeriode;
        this.anneeDebut = anneeDebut;
        this.anneeFin = anneeFin;
    }

    // Getters et setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomPeriode() {
        return nomPeriode;
    }

    public void setNomPeriode(String nomPeriode) {
        this.nomPeriode = nomPeriode;
    }

    public Integer getAnneeDebut() {
        return anneeDebut;
    }

    public void setAnneeDebut(Integer anneeDebut) {
        this.anneeDebut = anneeDebut;
    }

    public Integer getAnneeFin() {
        return anneeFin;
    }

    public void setAnneeFin(Integer anneeFin) {
        this.anneeFin = anneeFin;
    }
    public List<Livre> getLivres() {
        return livres;
    }
    
    public void setLivres(List<Livre> livres) {
        this.livres = livres;
    }
}
