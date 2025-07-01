package mg.itu.spring.repository;

import mg.itu.spring.model.Cotisation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import java.util.List;

@Repository
public interface CotisationRepository extends JpaRepository<Cotisation, Integer> {
    
    List<Cotisation> findByTypeMembreId(Integer typeMembreId);
    
    @Query("SELECT c FROM Cotisation c WHERE c.typeMembre.id = :typeMembreId ORDER BY c.dateChangement DESC")
    List<Cotisation> findLatestByTypeMembreId(@Param("typeMembreId") Integer typeMembreId, Pageable pageable);
    
    default Cotisation findCurrentByTypeMembreId(Integer typeMembreId) {
        List<Cotisation> result = findLatestByTypeMembreId(typeMembreId, PageRequest.of(0, 1));
        return result.isEmpty() ? null : result.get(0);
    }
}