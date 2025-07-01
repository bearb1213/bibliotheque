package mg.itu.spring.repository;

import mg.itu.spring.model.Penalite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;  

@Repository
public interface PenaliteRepository extends JpaRepository<Penalite, Integer> {

    // Trouver la pénalité par nombre de jours de retard
    Penalite findByNbJoursRetard(Integer nbJoursRetard);

    // Trouver les pénalités dont le montant par jour est supérieur à une valeur
    List<Penalite> findByPenaliteParJourGreaterThan(Integer montant);

    // Trouver les pénalités dont le montant par jour est inférieur à une valeur
    List<Penalite> findByPenaliteParJourLessThan(Integer montant);
}