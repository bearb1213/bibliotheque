package mg.itu.spring.repository;

import mg.itu.spring.model.MaisonEdition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface MaisonEditionRepository extends JpaRepository<MaisonEdition, Integer> {
    @Query("SELECT m FROM MaisonEdition m LEFT JOIN FETCH m.collections WHERE m.id = :id")
    Optional<MaisonEdition> findByIdWithCollections(@Param("id") Integer id);

    @Query("SELECT m FROM MaisonEdition m LEFT JOIN FETCH m.collections")
    List<MaisonEdition> findAllWithCollections();

}
