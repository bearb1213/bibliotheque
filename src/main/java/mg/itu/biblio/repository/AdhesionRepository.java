package mg.itu.biblio.repository;

import mg.itu.biblio.model.Adhesion;
import mg.itu.biblio.model.Utilisateur;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;


import java.util.Optional;
import java.util.List;

@Repository
public interface AdhesionRepository extends  JpaRepository<Adhesion, Integer>{
    
    @Query("SELECT a FROM Adhesion a WHERE a.utilisateur = :utilisateur AND :date BETWEEN a.dateDebut AND a.dateFin")
    Optional<Adhesion> findActiveByUtilisateurAndDate(@Param("utilisateur") Utilisateur utilisateur,
                                                      @Param("date") LocalDate date);


    @Query("SELECT a FROM Adhesion a WHERE a.utilisateur.id = :utilisateurId AND :date BETWEEN a.dateDebut AND a.dateFin")
    Optional<Adhesion> findActiveByUtilisateurIdAndDate(@Param("utilisateurId") Integer utilisateurId,
                                                        @Param("date") LocalDate date);

    @Query("SELECT a FROM Adhesion a WHERE a.utilisateur.id = :utilisateurId ORDER BY a.dateFin DESC")
    List<Adhesion> findLastAdhesionByUtilisateurId(@Param("utilisateurId") Integer utilisateurId, Pageable pageable);

}
