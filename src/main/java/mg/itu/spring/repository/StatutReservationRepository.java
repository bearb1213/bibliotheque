package mg.itu.spring.repository;

import mg.itu.spring.model.StatutReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StatutReservationRepository extends JpaRepository<StatutReservation, Integer> {

    Optional<StatutReservation> findByNomStatut(String nomStatut);
    
    boolean existsByNomStatut(String nomStatut);
    
}