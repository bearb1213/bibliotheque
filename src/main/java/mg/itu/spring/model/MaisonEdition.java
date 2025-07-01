package mg.itu.spring.model;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "maison_edition")
public class MaisonEdition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nom_edition")
    private String nomEdition;

    @OneToMany(mappedBy = "maisonEdition", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Collection> collections;

    // Constructeurs
    public MaisonEdition() {}

    public MaisonEdition(String nomEdition) {
        this.nomEdition = nomEdition;
    }

    // Getters et setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomEdition() {
        return nomEdition;
    }

    public void setNomEdition(String nomEdition) {
        this.nomEdition = nomEdition;
    }

    public List<Collection> getCollections() {
        return collections;
    }

    public void setCollections(List<Collection> collections) {
        this.collections = collections;
    }

}
