package mg.itu.spring.repository;

import mg.itu.spring.model.TypePret;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.*;


@Repository
public interface TypePretRepository extends JpaRepository<TypePret, Integer> {

    // Trouver un type de prêt par son nom
    TypePret findByNomTypePret(String nomTypePret);

    // Vérifier si un type de prêt existe déjà
    boolean existsByNomTypePret(String nomTypePret);

    
    @Query("SELECT DISTINCT e FROM TypePret e " +
    "LEFT JOIN FETCH e.prets " +  
    "WHERE e.id = :id")
    Optional<TypePret> findByIdWithPrets(@Param("id") Integer id);

    @Query("SELECT DISTINCT e FROM TypePret e " +
           "LEFT JOIN FETCH e.prets")
    List<TypePret> findAllWithPrets();
}