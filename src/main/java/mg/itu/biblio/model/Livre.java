package mg.itu.biblio.model;


import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.List;  

@Entity
@Table(name = "Livre")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Livre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "titre")
    private String titre;
    
    @Column(name = "synopsis")
    private String synopsis;
    
    @Column(name = "date_publication")
    private LocalDate datePublication;
    
    @Column(name = "page")
    private Integer page;
    
    @Column(name = "age_lim")
    private Integer ageLim;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_auteur")
    private Auteur auteur;
    
    
    @ManyToMany
    @JoinTable(
        name = "livre_genre",
        joinColumns = @JoinColumn(name = "id_livre"),
        inverseJoinColumns = @JoinColumn(name = "id_genre")
    )
    private List<Genre> genres;

}
