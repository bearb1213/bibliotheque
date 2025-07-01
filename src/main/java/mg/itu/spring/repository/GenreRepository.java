package mg.itu.spring.repository;

import mg.itu.spring.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer> {
    Genre findByNom(String nom);

    @Query("SELECT a FROM Auteur a LEFT JOIN FETCH a.livres WHERE a.id = :id")
    Optional<Auteur> findByIdWithLivres(@Param("id") Integer id);

    @Query("SELECT DISTINCT a FROM Auteur a LEFT JOIN FETCH a.livres")
    List<Auteur> findAllWithLivres();

}
