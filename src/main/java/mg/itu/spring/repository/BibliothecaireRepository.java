package mg.itu.spring.repository;

import mg.itu.spring.model.Bibliothecaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BibliothecaireRepository extends JpaRepository<Bibliothecaire, Integer> {

    // Trouver un bibliothécaire par son ID utilisateur
    Bibliothecaire findByUtilisateurId(Integer utilisateurId);

    // Vérifier si un utilisateur est bibliothécaire
    boolean existsByUtilisateurId(Integer utilisateurId);

    

}