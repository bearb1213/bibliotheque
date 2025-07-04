package mg.itu.biblio.repository;

import mg.itu.biblio.model.Pret;
import mg.itu.biblio.model.Utilisateur;
import mg.itu.biblio.model.Exemplaire;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


@Repository
public interface PretRepository extends JpaRepository<Pret, Integer> {
    int countByUtilisateurAndDateVretourIsNull(Utilisateur utilisateur);
    List<Pret> findByExemplaireAndDateVretourIsNull(Exemplaire exemplaire);
    List<Pret> findAllByDateVretourIsNull();

}
