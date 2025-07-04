package mg.itu.biblio.service;


import java.time.LocalDate;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mg.itu.biblio.model.*;
import mg.itu.biblio.repository.*;

import java.util.List;

@Service
public class PretService {
    @Autowired
    private AdhesionService adhesionService;
    
    @Autowired
    private PretRepository pretRepository;

    @Autowired
    private PenaliteRepository penaliteRepository;
    
    @Autowired
    private PenaliteTypeRepository penaliteTypeRepository;
    
    @Autowired
    private QuotaRepository quotaRepository;

    public Pret preter(Utilisateur utilisateur,Exemplaire exemplaire,TypePret typePret)throws Exception{
        Adhesion adhesion = adhesionService.getAdherent(utilisateur, LocalDate.now());
        if(adhesion==null){
            throw new Exception("Utilisateur non adherer");
        }
        List<Pret> prets = pretRepository.findByExemplaireAndDateVretourIsNull(exemplaire);
        if(!prets.isEmpty()){
            throw new Exception("Exemplaire deja en cours de pret");
        }
        // a faire penalite
        if(typePret.getId()==1){
            Pret pret = new Pret(null,LocalDate.now(),LocalDate.now().plusDays(1),null,typePret,utilisateur,exemplaire);
            pretRepository.save(pret);
            return pret;
        } else {
            List<Penalite> penalites= penaliteRepository.findByUtilisateurAndDateDebutLessThanEqualAndDateFinGreaterThanEqual(utilisateur, LocalDate.now(), LocalDate.now());
            if (!penalites.isEmpty()) {
                throw new Exception("Vous etes penaliser jusqu a "+penalites.get(0).getDateFin());
            }
            int nbPret = pretRepository.countByUtilisateurAndDateVretourIsNull(utilisateur);
            Quota quota = quotaRepository.findByActionAndTypeAdhesion("pret" , adhesion.getTypeAdhesion()).get(0);
            if(nbPret>=quota.getQuota()){
                throw new Exception("vous avez attends votre quota actuelle : "+nbPret+" total : "+quota.getQuota());
            }
            // a modifier
            int nbJour = 5;
            
            Pret pret = new Pret(null,LocalDate.now(),LocalDate.now().plusDays(nbJour),null,typePret,utilisateur,exemplaire);
            pretRepository.save(pret);
            return pret;
        }

    }
    public List<Pret> findAll(){
        return pretRepository.findAllByDateVretourIsNull();
    }

    public Pret rendre(Pret pret,LocalDate date)throws Exception{
        LocalDate dateRetour = pret.getDateRetour();
        if(date.isAfter(dateRetour)){
            pret.setDateVretour(date);    
            pretRepository.save(pret);
            Utilisateur utilisateur = pret.getUtilisateur();
            Adhesion adhesion = adhesionService.getAdherent(utilisateur,date);
            if(adhesion==null){
                Penalite penalite = new Penalite(null,date,date.plusDays(10),utilisateur);
                penaliteRepository.save(penalite);
            } else {
                PenaliteType penaliteType = penaliteTypeRepository.findByType(adhesion.getTypeAdhesion()).get(0);
                Penalite penalite = new Penalite(null,date,date.plusDays(penaliteType.getNbjour()),utilisateur);
                penaliteRepository.save(penalite);
            }
            return pret;
        } else {
            pret.setDateVretour(date);
            pretRepository.save(pret);
            return pret;
        }
    }
    public Pret findById(Integer id){
        return pretRepository.findById(id).orElse(null);
    }

}
