package mg.itu.spring.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "collection")
public class Collection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nom_collection")
    private String nomCollection;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_maison_edition", nullable = false)
    private MaisonEdition maisonEdition;

    @OneToMany(mappedBy = "auteur", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Livre> livres;
    // Constructeurs
    public Collection() {}

    public Collection(String nomCollection, MaisonEdition maisonEdition) {
        this.nomCollection = nomCollection;
        this.maisonEdition = maisonEdition;
    }

    // Getters et setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomCollection() {
        return nomCollection;
    }

    public void setNomCollection(String nomCollection) {
        this.nomCollection = nomCollection;
    }

    public MaisonEdition getMaisonEdition() {
        return maisonEdition;
    }

    public void setMaisonEdition(MaisonEdition maisonEdition) {
        this.maisonEdition = maisonEdition;
    }
    public List<Livre> getLivres() {
        return livres;
    }
    
    public void setLivres(List<Livre> livres) {
        this.livres = livres;
    }
}
