package mg.itu.biblio.repository;

import mg.itu.biblio.model.Penalite;
import mg.itu.biblio.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PenaliteRepository extends JpaRepository<Penalite, Integer> {

    // Trouve les pénalités d'un utilisateur où une date est entre dateDebut et dateFin
    List<Penalite> findByUtilisateurAndDateDebutLessThanEqualAndDateFinGreaterThanEqual(
        Utilisateur utilisateur,
        LocalDate date,
        LocalDate date2
    );
}
