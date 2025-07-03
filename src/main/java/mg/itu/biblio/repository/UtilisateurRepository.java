package mg.itu.biblio.repository;

import mg.itu.biblio.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
    
    Utilisateur findByEmail(String email);
    Utilisateur findByEmailAndMotDePasse(String email, String motDePasse);
    
}
