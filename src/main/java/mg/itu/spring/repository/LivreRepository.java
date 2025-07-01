package mg.itu.spring.repository;

import mg.itu.spring.model.Livre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface LivreRepository extends JpaRepository<Livre, Integer> {

    // Rechercher par titre exact
    List<Livre> findByTitre(String titre);

    // Rechercher par titre contenant une partie (insensible à la casse si configuré)
    List<Livre> findByTitreContainingIgnoreCase(String motCle);

    // Rechercher par langue
    List<Livre> findByLangue(String langue);

    // Rechercher par ISBN
    Livre findByIsbn(String isbn);

    // Rechercher les livres d’un auteur donné
    List<Livre> findByAuteurId(Integer auteurId);

    // Rechercher les livres d’un genre donné
    List<Livre> findByGenreId(Integer genreId);

    // Rechercher les livres d’une période précise
    List<Livre> findByPeriodeId(Integer periodeId);

    // Rechercher par collection
    List<Livre> findByCollectionId(Integer collectionId);

    // Rechercher entre deux années de première édition
    List<Livre> findByPremiereEditionBetween(Date debut, Date fin);

    // Rechercher les livres avec un nombre de pages supérieur à X
    List<Livre> findByNbPagesGreaterThan(Integer minPages);

    // Rechercher les livres avec un nombre de pages inférieur à X
    List<Livre> findByNbPagesLessThan(Integer maxPages);

    
    @Query("SELECT l FROM Livre l WHERE l.ageLimite IS NULL OR l.ageLimite <= :ageMax")
    List<Livre> findByAgeLimiteNullOrLessThanEqual(@Param("ageMax") Integer ageMax);
}
