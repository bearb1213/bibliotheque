package mg.itu.spring.repository;

import mg.itu.spring.model.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.List;

@Repository
public interface PaiementRepository extends JpaRepository<Paiement, Integer> {
    
    // Trouver les paiements d'un utilisateur
    List<Paiement> findByUtilisateurId(Integer utilisateurId);
    
    // Trouver les paiements par type de membre
    List<Paiement> findByTypeMembreId(Integer typeMembreId);
    
    // Trouver les paiements entre deux dates
    @Query("SELECT p FROM Paiement p WHERE p.datePaiement BETWEEN :startDate AND :endDate")
    List<Paiement> findBetweenDates(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
    
    // Trouver le montant total des paiements d'un utilisateur
    @Query("SELECT SUM(p.montant) FROM Paiement p WHERE p.utilisateur.id = :utilisateurId")
    Double getTotalPaiementsByUtilisateur(@Param("utilisateurId") Integer utilisateurId);
}