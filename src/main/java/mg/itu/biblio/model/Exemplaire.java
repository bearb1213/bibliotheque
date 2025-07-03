    package mg.itu.biblio.model;

    import java.time.LocalDate;

    import jakarta.persistence.*;
    import lombok.*;


    @Entity
    @Table(name = "exemplaire")
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class Exemplaire {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        @Column(name = "date_arrive")
        private LocalDate dateArrive;

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "id_livre")
        private Livre livre;


    }
