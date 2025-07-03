package mg.itu.biblio.service;

import mg.itu.biblio.model.Utilisateur;
import mg.itu.biblio.repository.UtilisateurRepository;

import org.springframework.beans.factory.annotation.Autowired;

import mg.itu.biblio.model.Adhesion;
import mg.itu.biblio.repository.AdhesionRepository;

import mg.itu.biblio.model.TypeAdhesion;
import mg.itu.biblio.repository.TypeAdhesionRepository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AdhesionService {
    @Autowired
    UtilisateurRepository utilisateurRepository;

    @Autowired
    AdhesionRepository adhesionRepository;

    @Autowired
    TypeAdhesionRepository typeAdhesionRepository;

    public Adhesion getAdherent(Integer id,LocalDate date){
        Utilisateur utilisateur = utilisateurRepository.findById(id).orElse(null);
        return adhesionRepository.findActiveByUtilisateurAndDate(utilisateur, date).orElse(null);
    }

    public Adhesion getLastAdhesion(Integer id){
        List<Adhesion> adhesions = adhesionRepository.findLastAdhesionByUtilisateurId(id,PageRequest.of(0, 1));
        return  adhesions.isEmpty() ? null : adhesions.get(0); 
    }

    public List<TypeAdhesion> getAllTypeAdhesions(){
        return typeAdhesionRepository.findAll();
    }
    public TypeAdhesion getTypeAdhesion(Integer id){
        return typeAdhesionRepository.findById(id).orElse(null);
    }

    public Adhesion adherer(Utilisateur utilisateur,TypeAdhesion typeAdhesion,Integer nbMois ){
        Adhesion last = getLastAdhesion(utilisateur.getId());
        
        if(last==null){
            Adhesion adhesion = new Adhesion(null,LocalDate.now(),LocalDate.now().plusMonths(nbMois),typeAdhesion,utilisateur);
            adhesionRepository.save(adhesion);
            return adhesion;
        } else {
            if(LocalDate.now().isAfter(last.getDateFin())){
                Adhesion adhesion = new Adhesion(null,LocalDate.now(),LocalDate.now().plusMonths(nbMois),typeAdhesion,utilisateur);
                adhesionRepository.save(adhesion);
                return adhesion;
            } else {
                Adhesion adhesion = new Adhesion(null,last.getDateFin(),last.getDateFin().plusMonths(nbMois),typeAdhesion,utilisateur);
                adhesionRepository.save(adhesion);
                return adhesion;
            }
        }
    }


    

}
