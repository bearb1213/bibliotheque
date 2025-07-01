package mg.itu.spring.repository;

import mg.itu.spring.model.Auteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AuteurRepository extends JpaRepository<Auteur, Integer> {
    @Query("SELECT a FROM Auteur a LEFT JOIN FETCH a.livres WHERE a.id = :id")
    Optional<Auteur> findByIdWithLivres(@Param("id") Integer id);

    @Query("SELECT DISTINCT a FROM Auteur a LEFT JOIN FETCH a.livres")
    List<Auteur> findAllWithLivres();

}
