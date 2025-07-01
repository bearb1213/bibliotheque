package mg.itu.spring.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "livre")
public class Livre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String isbn;

    @Column(nullable = false)
    private String titre;

    @Lob
    private String resume;

    @Column(name = "premiere_edition")
    private LocalDate premiereEdition;

    private String langue;

    @Column(name = "nb_pages")
    private Integer nbPages;

    @Column(name = "age_limite")
    private Integer ageLimite;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_periode", nullable = false)
    private Periode periode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_collection", nullable = false)
    private Collection collection;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_genre", nullable = false)
    private Genre genre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_auteur", nullable = false)
    private Auteur auteur;

    // Constructeurs
    public Livre() {
    }

    public Livre(String isbn, String titre, String resume, LocalDate premiereEdition, 
                String langue, Integer nbPages, Integer ageLimite, Periode periode, 
                Collection collection, Genre genre, Auteur auteur) {
        this.isbn = isbn;
        this.titre = titre;
        this.resume = resume;
        this.premiereEdition = premiereEdition;
        this.langue = langue;
        this.nbPages = nbPages;
        this.ageLimite = ageLimite;
        this.periode = periode;
        this.collection = collection;
        this.genre = genre;
        this.auteur = auteur;
    }

    // Getters et Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public LocalDate getPremiereEdition() {
        return premiereEdition;
    }

    public void setPremiereEdition(LocalDate premiereEdition) {
        this.premiereEdition = premiereEdition;
    }

    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    public Integer getNbPages() {
        return nbPages;
    }

    public void setNbPages(Integer nbPages) {
        this.nbPages = nbPages;
    }

    public Integer getAgeLimite() {
        return ageLimite;
    }

    public void setAgeLimite(Integer ageLimite) {
        this.ageLimite = ageLimite;
    }

    public Periode getPeriode() {
        return periode;
    }

    public void setPeriode(Periode periode) {
        this.periode = periode;
    }

    public Collection getCollection() {
        return collection;
    }

    public void setCollection(Collection collection) {
        this.collection = collection;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Auteur getAuteur() {
        return auteur;
    }

    public void setAuteur(Auteur auteur) {
        this.auteur = auteur;
    }

    @Override
    public String toString() {
        return "Livre{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", isbn='" + isbn + '\'' +
                '}';
    }
}