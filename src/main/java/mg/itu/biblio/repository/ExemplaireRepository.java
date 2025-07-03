package mg.itu.biblio.repository;

import mg.itu.biblio.model.Exemplaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  ExemplaireRepository extends JpaRepository<Exemplaire, Integer> {
    
}
