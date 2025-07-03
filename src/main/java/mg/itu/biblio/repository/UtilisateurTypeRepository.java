package mg.itu.biblio.repository;

import mg.itu.biblio.model.UtilisateurType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurTypeRepository extends JpaRepository<UtilisateurType, Integer> {
    
    
}
