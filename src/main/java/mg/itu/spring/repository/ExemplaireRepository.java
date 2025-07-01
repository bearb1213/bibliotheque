package mg.itu.spring.repository;

import mg.itu.spring.model.Exemplaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface ExemplaireRepository extends JpaRepository<Exemplaire, Integer> {

    // Chercher tous les exemplaires d’un livre donné
    List<Exemplaire> findByLivreId(Integer livreId);

    // Chercher par date d'arrivée exacte
    List<Exemplaire> findByDateArrivee(java.sql.Date date);

    @Query("SELECT DISTINCT e FROM Exemplaire e " +
    "LEFT JOIN FETCH e.prets " +  
    "WHERE e.id = :id")
    Optional<Exemplaire> findByIdWithPrets(@Param("id") Integer id);

    @Query("SELECT DISTINCT e FROM Exemplaire e " +
           "LEFT JOIN FETCH e.prets")
    List<Exemplaire> findAllWithPrets();
}
