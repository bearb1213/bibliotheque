package mg.itu.spring.repository;

import mg.itu.spring.model.Statut;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatutRepository extends JpaRepository<Statut, Integer> {
    Statut findByNomStatut(String nomStatut);
}
