package mg.itu.spring.repository;

import mg.itu.spring.model.Adherent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AdherentRepository extends JpaRepository<Adherent, Integer> {

    // Trouver les adhésions d'un utilisateur
    List<Adherent> findByUtilisateurId(Integer utilisateurId);

    // Trouver les adhésions d'un type de membre
    List<Adherent> findByTypeMembreId(Integer typeMembreId);

    // Trouver les adhésions actives à une date donnée
    @Query("SELECT a FROM Adherent a WHERE :date BETWEEN a.dateDebut AND a.dateFin")
    List<Adherent> findAdhesionsActivesAtDate(@Param("date") Date date);

    // Trouver les adhésions expirées
    @Query("SELECT a FROM Adherent a WHERE a.dateFin < CURRENT_DATE")
    List<Adherent> findAdhesionsExpirees();

    // Trouver les adhésions à venir
    @Query("SELECT a FROM Adherent a WHERE a.dateDebut > CURRENT_DATE")
    List<Adherent> findAdhesionsAVenir();

    // Vérifier si un utilisateur a une adhésion active
    @Query("SELECT COUNT(a) > 0 FROM Adherent a WHERE a.utilisateur.id = :utilisateurId AND CURRENT_DATE BETWEEN a.dateDebut AND a.dateFin")
    boolean hasAdhesionActive(@Param("utilisateurId") Integer utilisateurId);

    @Query("SELECT CASE WHEN COUNT(a) > 0 THEN true ELSE false END " +
    "FROM Adherent a " +
    "WHERE a.utilisateur.id = :utilisateurId AND a.dateFin < CURRENT_DATE")
    boolean isUserAdhesionExpiree(@Param("utilisateurId") Integer utilisateurId);

    @Query("SELECT DISTINCT a FROM Adherent a LEFT JOIN FETCH a.prets WHERE a.id = :id")
    Optional<Adherent> findByIdWithPrets(@Param("id") Integer id);

    @Query("SELECT a FROM Adherent a LEFT JOIN FETCH a.prets")
    List<Adherent> findAllWithPrets();

}