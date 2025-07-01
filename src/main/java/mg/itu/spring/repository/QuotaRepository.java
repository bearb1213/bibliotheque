package mg.itu.spring.repository;

import mg.itu.spring.model.Quota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface QuotaRepository extends JpaRepository<Quota, Integer> {

    // Trouver les quotas d'un type de membre
    List<Quota> findByTypeMembreId(Integer typeMembreId);

    // Trouver le quota actif (le plus récent) pour un type de membre
    @Query("SELECT q FROM Quota q WHERE q.typeMembre.id = :typeMembreId ORDER BY q.dateChangement DESC LIMIT 1")
    Optional<Quota> findCurrentByTypeMembreId(@Param("typeMembreId") Integer typeMembreId);

    // Trouver les quotas actifs à une date donnée
    @Query("SELECT q FROM Quota q WHERE q.dateChangement <= :date AND " +
           "q.id = (SELECT MAX(q2.id) FROM Quota q2 WHERE q2.typeMembre.id = q.typeMembre.id AND q2.dateChangement <= :date)")
    List<Quota> findActiveAtDate(@Param("date") Date date);

    // Trouver l'historique des changements de quota pour un type de membre
    @Query("SELECT q FROM Quota q WHERE q.typeMembre.id = :typeMembreId ORDER BY q.dateChangement DESC")
    List<Quota> findHistoryByTypeMembreId(@Param("typeMembreId") Integer typeMembreId);

    // Vérifier si une valeur de quota existe déjà pour un type de membre
    boolean existsByValeurAndTypeMembreId(Integer valeur, Integer typeMembreId);
}