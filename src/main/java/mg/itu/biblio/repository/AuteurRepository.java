package mg.itu.biblio.repository;

import mg.itu.biblio.model.Auteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuteurRepository extends JpaRepository<Auteur, Integer> {
    
}
