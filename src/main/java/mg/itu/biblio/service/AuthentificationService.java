package mg.itu.biblio.service;


import mg.itu.biblio.model.Utilisateur;
import mg.itu.biblio.model.UtilisateurType;
import mg.itu.biblio.repository.UtilisateurRepository;
import mg.itu.biblio.repository.UtilisateurTypeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AuthentificationService {
    @Autowired
    UtilisateurRepository utilisateurRepository;

    @Autowired
    UtilisateurTypeRepository utilisateurTypeRepository;

    public Utilisateur createUtilisateur(Utilisateur utilisateur) {
        // Ici, on suppose que l'objet utilisateurType est déjà correctement rempli
        return utilisateurRepository.save(utilisateur);
    }

    public UtilisateurType getTypeById(int id){
        return utilisateurTypeRepository.findById(id).orElse(null);
    }

    public Utilisateur findUtilisateur(String email,String mdp){
        return utilisateurRepository.findByEmailAndMotDePasse(email, mdp);
    }
    public Utilisateur findUtilisateur(String email){
        return utilisateurRepository.findByEmail(email);
    }
    

}
