package mg.itu.spring.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "utilisateur")
public class Utilisateur {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(nullable = false)
    private String nom;
    
    private String prenom;
    
    private String email;
    
    private String telephone;
    
    @Column(name = "mot_de_passe", nullable = false)
    private String motDePasse;

    // Relation avec les paiements
    @OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Paiement> paiements;

    // Relation avec bibliothécaire (si l'utilisateur est un bibliothécaire)
    @OneToOne(mappedBy = "utilisateur", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Bibliothecaire bibliothecaire;

    @OneToMany(mappedBy = "utilisateur",
               cascade = CascadeType.ALL,
               fetch = FetchType.LAZY)
    private List<Adherent> adhesions ;

    // Constructeurs
    public Utilisateur() {
    }
    
    public Utilisateur(String nom, String prenom, String email, String telephone, String motDePasse) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.motDePasse = motDePasse;
    }
    
    // Getters et Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public List<Paiement> getPaiements() {
        return paiements;
    }

    public void setPaiements(List<Paiement> paiements) {
        this.paiements = paiements;
    }

    public Bibliothecaire getBibliothecaire() {
        return bibliothecaire;
    }

    public void setBibliothecaire(Bibliothecaire bibliothecaire) {
        this.bibliothecaire = bibliothecaire;
    }
    public List<Adherent> getAdhesions() { return adhesions; }
    public void setAdhesions(List<Adherent> adhesions) { this.adhesions = adhesions; }

    public void addAdhesion(Adherent adhesion) {
        adhesions.add(adhesion);
        adhesion.setUtilisateur(this);
    }
    public boolean hasAdhesionActive() {
        Date now = new Date();
        return adhesions.stream()
                .anyMatch(a -> a.getDateDebut().before(now) && a.getDateFin().after(now));
    }

    // Méthode utilitaire pour ajouter un paiement
    public void addPaiement(Paiement paiement) {
        paiements.add(paiement);
        paiement.setUtilisateur(this);
    }

    // Méthode utilitaire pour vérifier si l'utilisateur est bibliothécaire
    public boolean isBibliothecaire() {
        return this.bibliothecaire != null;
    }
    
    // Méthode toString() (exclure motDePasse pour des raisons de sécurité)
    @Override
    public String toString() {
        return "Utilisateur{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}