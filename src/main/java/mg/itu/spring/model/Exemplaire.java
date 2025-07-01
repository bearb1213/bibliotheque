package mg.itu.spring.model;

import jakarta.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "exemplaire")
public class Exemplaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "date_arrivee")
    private Date dateArrivee;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_livre", nullable = false)
    private Livre livre;

    @OneToMany(mappedBy = "exemplaire", 
               cascade = CascadeType.ALL, 
               orphanRemoval = true,
               fetch = FetchType.LAZY)
    private List<Pret> prets = new ArrayList<>();

    // Constructeurs
    public Exemplaire() {}

    public Exemplaire(Date dateArrivee, Livre livre) {
        this.dateArrivee = dateArrivee;
        this.livre = livre;
    }

    // Getters et setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateArrivee() {
        return dateArrivee;
    }

    public void setDateArrivee(Date dateArrivee) {
        this.dateArrivee = dateArrivee;
    }

    public Livre getLivre() {
        return livre;
    }

    public void setLivre(Livre livre) {
        this.livre = livre;
    }

    public List<Pret> getPrets() {
        return prets;
    }

    public void setPrets(List<Pret> prets) {
        this.prets = prets;
    }

    // Méthodes utilitaires
    public void addPret(Pret pret) {
        prets.add(pret);
        pret.setExemplaire(this);
    }

    public void removePret(Pret pret) {
        prets.remove(pret);
        pret.setExemplaire(null);
    }

    // Vérifie si l'exemplaire est actuellement prêté
    public boolean estEmprunte() {
        Date now = new Date(System.currentTimeMillis());
        return prets.stream()
                .anyMatch(pret -> pret.getDateDebut().before(now) && 
                                 pret.getDateFin().after(now));
    }

    @Override
    public String toString() {
        return "Exemplaire{" +
                "id=" + id +
                ", dateArrivee=" + dateArrivee +
                '}';
    }
}