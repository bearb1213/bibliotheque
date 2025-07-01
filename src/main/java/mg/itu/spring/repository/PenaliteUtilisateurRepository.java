package mg.itu.spring.repository;

import mg.itu.spring.model.PenaliteUtilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PenaliteUtilisateurRepository extends JpaRepository<PenaliteUtilisateur, Integer> {

    // Trouver les pénalités d'un utilisateur
    List<PenaliteUtilisateur> findByUtilisateurId(Integer utilisateurId);

    // Trouver les pénalités d'un type spécifique pour un utilisateur
    List<PenaliteUtilisateur> findByUtilisateurIdAndPenaliteId(Integer utilisateurId, Integer penaliteId);

    // Trouver les pénalités actives à une date donnée
    @Query("SELECT pu FROM PenaliteUtilisateur pu WHERE :date BETWEEN pu.dateDebut AND pu.dateFin")
    List<PenaliteUtilisateur> findActiveAtDate(@Param("date") Date date);

    // Trouver les pénalités actives d'un utilisateur
    @Query("SELECT pu FROM PenaliteUtilisateur pu " +
           "WHERE pu.utilisateur.id = :utilisateurId " +
           "AND CURRENT_DATE BETWEEN pu.dateDebut AND pu.dateFin")
    List<PenaliteUtilisateur> findActiveByUtilisateur(@Param("utilisateurId") Integer utilisateurId);

    // Vérifier si un utilisateur a une pénalité active d'un type spécifique
    @Query("SELECT COUNT(pu) > 0 FROM PenaliteUtilisateur pu " +
           "WHERE pu.utilisateur.id = :utilisateurId " +
           "AND pu.penalite.id = :penaliteId " +
           "AND CURRENT_DATE BETWEEN pu.dateDebut AND pu.dateFin")
    boolean hasActivePenaliteOfType(
            @Param("utilisateurId") Integer utilisateurId,
            @Param("penaliteId") Integer penaliteId);
}