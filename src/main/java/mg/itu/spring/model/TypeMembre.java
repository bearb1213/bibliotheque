package mg.itu.spring.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "type_membre")
public class TypeMembre {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "nom_type", nullable = false, unique = true)
    private String nomType;
    
    @Column(nullable = false)
    private Double cotisation;
    
    @OneToMany(mappedBy = "typeMembre", 
               cascade = CascadeType.ALL, 
               orphanRemoval = true,
               fetch = FetchType.LAZY)
    private List<Cotisation> cotisations = new ArrayList<>();
    
    @OneToMany(mappedBy = "typeMembre",
               fetch = FetchType.LAZY)
    private List<Adherent> adherents = new ArrayList<>();
    
    // Constructeurs
    public TypeMembre() {
    }
    
    public TypeMembre(String nomType, Double cotisation) {
        this.nomType = nomType;
        this.cotisation = cotisation;
    }
    
    // Getters et Setters
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getNomType() {
        return nomType;
    }
    
    public void setNomType(String nomType) {
        this.nomType = nomType;
    }
    
    public Double getCotisation() {
        return cotisation;
    }
    
    public void setCotisation(Double cotisation) {
        this.cotisation = cotisation;
    }
    
    public List<Cotisation> getCotisations() {
        return cotisations;
    }
    
    public void setCotisations(List<Cotisation> cotisations) {
        this.cotisations = cotisations;
    }
    
    public List<Adherent> getAdherents() {
        return adherents;
    }
    
    public void setAdherents(List<Adherent> adherents) {
        this.adherents = adherents;
    }
    
    // Méthodes utilitaires
    public void addCotisation(Cotisation cotisation) {
        cotisations.add(cotisation);
        cotisation.setTypeMembre(this);
    }
    
    public void removeCotisation(Cotisation cotisation) {
        cotisations.remove(cotisation);
        cotisation.setTypeMembre(null);
    }
    
    public void addAdherent(Adherent adherent) {
        adherents.add(adherent);
        adherent.setTypeMembre(this);
    }
    
    public void removeAdherent(Adherent adherent) {
        adherents.remove(adherent);
        adherent.setTypeMembre(null);
    }
    
    // Méthode pour compter les adhérents actifs
    public long countActiveAdherents() {
        Date now = new Date();
        return adherents.stream()
                .filter(a -> a.getDateDebut().before(now) && a.getDateFin().after(now))
                .count();
    }
    
    @Override
    public String toString() {
        return "TypeMembre{" +
                "id=" + id +
                ", nomType='" + nomType + '\'' +
                ", cotisation=" + cotisation +
                '}';
    }
}