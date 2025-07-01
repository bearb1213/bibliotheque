package mg.itu.spring.repository;

import mg.itu.spring.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
    
    // Méthode pour trouver un utilisateur par email
    
    Optional<Utilisateur> findByEmail(String email);

    Optional<Utilisateur> findByEmailAndMotDePasse(String email, String motDePasse);
    
    // Méthode pour vérifier l'existence d'un email
    boolean existsByEmail(String email);
    

    @Query("SELECT DISTINCT u FROM Utilisateur u LEFT JOIN FETCH u.paiements WHERE u.id = :id")
    Optional<Utilisateur> findByIdWithPaiements(@Param("id") Integer id);

    @Query("SELECT DISTINCT u FROM Utilisateur u LEFT JOIN FETCH u.paiements")
    List<Utilisateur> findAllWithPaiements();

    @Query("SELECT CASE WHEN COUNT(b) > 0 THEN true ELSE false END FROM Bibliothecaire b WHERE b.utilisateur.id = :userId")
    boolean isBibliothecaire(@Param("userId") Integer userId);

    @Query("SELECT DISTINCT u FROM Utilisateur u LEFT JOIN FETCH u.adhesions WHERE u.id = :id")
    Optional<Utilisateur> findByIdWithAdhesions(@Param("id") Integer id);

    @Query("SELECT DISTINCT u FROM Utilisateur u LEFT JOIN FETCH u.adhesions")
    List<Utilisateur> findAllWithAdhesions();

    @Query("SELECT DISTINCT u FROM Utilisateur u " +
       "LEFT JOIN FETCH u.adhesions " +
       "LEFT JOIN FETCH u.paiements " +
       "WHERE u.id = :id")
    Optional<Utilisateur> findByIdWithAdhesionsAndPaiements(@Param("id") Integer id);

    @Query("SELECT DISTINCT u FROM Utilisateur u " +
        "LEFT JOIN FETCH u.adhesions " +
        "LEFT JOIN FETCH u.paiements")
    List<Utilisateur> findAllWithAdhesionsAndPaiements();

}