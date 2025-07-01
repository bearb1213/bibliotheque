package mg.itu.spring.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "type_pret")
public class TypePret {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nom_type_pret", nullable = false, unique = true)
    private String nomTypePret;

    
    @OneToMany(mappedBy = "typePret", 
               cascade = CascadeType.ALL, 
               orphanRemoval = true,
               fetch = FetchType.LAZY)
    private List<Pret> prets = new ArrayList<>();

    // Constructeurs
    public TypePret() {
    }

    public TypePret(String nomTypePret) {
        this.nomTypePret = nomTypePret;
    }

    // Getters et Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomTypePret() {
        return nomTypePret;
    }

    public void setNomTypePret(String nomTypePret) {
        this.nomTypePret = nomTypePret;
    }

    public List<Pret> getPrets() {
        return prets;
    }

    public void setPrets(List<Pret> prets) {
        this.prets = prets;
    }

    // Méthode toString()
    @Override
    public String toString() {
        return "TypePret{" +
                "id=" + id +
                ", nomTypePret='" + nomTypePret + '\'' +
                '}';
    }
}