package mg.itu.spring.repository;

import mg.itu.spring.model.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface CollectionRepository extends JpaRepository<Collection, Integer> {
    @Query("SELECT a FROM Auteur a LEFT JOIN FETCH a.livres WHERE a.id = :id")
    Optional<Auteur> findByIdWithLivres(@Param("id") Integer id);

    @Query("SELECT DISTINCT a FROM Auteur a LEFT JOIN FETCH a.livres")
    List<Auteur> findAllWithLivres();

}