package mg.itu.spring.repository;

import mg.itu.spring.model.Pret;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface PretRepository extends JpaRepository<Pret, Integer> {

    // Trouver les prêts d'un adhérent
    List<Pret> findByAdherentId(Integer adherentId);

    // Trouver les prêts d'un exemplaire
    List<Pret> findByExemplaireId(Integer exemplaireId);

    // Trouver les prêts en cours
    @Query("SELECT p FROM Pret p WHERE :date BETWEEN p.dateDebut AND p.dateFin")
    List<Pret> findEnCoursAtDate(@Param("date") Date date);

    // Trouver les prêts en retard
    @Query("SELECT p FROM Pret p WHERE p.dateFin < :date")
    List<Pret> findEnRetardAtDate(@Param("date") Date date);

    // Trouver les prêts par type
    List<Pret> findByTypePretId(Integer typePretId);

    // Trouver les prêts avec toutes les relations
    @Query("SELECT DISTINCT p FROM Pret p " +
           "LEFT JOIN FETCH p.exemplaire " +
           "LEFT JOIN FETCH p.typePret " +
           "LEFT JOIN FETCH p.adherent " +
           "WHERE p.id = :id")
    Optional<Pret> findByIdWithDetails(@Param("id") Integer id);

    // Statistiques des prêts
    @Query("SELECT COUNT(p), p.typePret.nom FROM Pret p GROUP BY p.typePret")
    List<Object[]> countByTypePret();
}