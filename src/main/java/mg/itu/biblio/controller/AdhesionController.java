package mg.itu.biblio.controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import mg.itu.biblio.service.AdhesionService;
import mg.itu.biblio.model.Adhesion;
import org.springframework.ui.Model;

import java.util.List;

import mg.itu.biblio.model.TypeAdhesion;


import mg.itu.biblio.service.AuthentificationService;
import mg.itu.biblio.model.Utilisateur;

@Controller
@RequestMapping("/adhesion")
public class AdhesionController{
    @Autowired
    private AdhesionService adhesionService;

    @Autowired
    private AuthentificationService authentificationService;

    @GetMapping("/")
    public String adhesionForm(Model model){
        model.addAttribute("typeAdhesions" , adhesionService.getAllTypeAdhesions());
        return "adhesion/form";
    }
    @PostMapping("/enregistrer")
    public String adherer(@RequestParam("email") String email,                    
                        @RequestParam("mdp") String mdp,
                        @RequestParam("nbMois") String nbMois,
                        @RequestParam("idType") String idType,
                        Model model,
                        HttpSession session
                        ){
        try {
            Integer Ustype = (Integer) session.getAttribute("utilisateurType");
            if(Ustype == null){
                throw new Exception("Connecter vous");
            }
            if (Ustype.equals(1)) {
                throw new Exception("Vous n'avez pas l'autorization");
            }
            Utilisateur user = authentificationService.findUtilisateur(email, mdp);
            if(user==null){
                throw new Exception("Identifiant incorrecte");
            }
            TypeAdhesion typeAdhesion = adhesionService.getTypeAdhesion(Integer.parseInt(idType));
            if(typeAdhesion==null){
                throw new Exception("Type innexistant");
            }
            Integer mois = Integer.parseInt(nbMois);
            if(mois<=0){
                throw new Exception("mois nefatif");
            }
            Adhesion add = adhesionService.adherer(user, typeAdhesion, mois);
            model.addAttribute("message", "Adhesion de "+add.getDateDebut()+" jusqu a "+add.getDateFin());
            
        } catch (Exception e) {
            model.addAttribute("message", e.getMessage());
        }
        model.addAttribute("typeAdhesions" , adhesionService.getAllTypeAdhesions());
        return "adhesion/form";
    }

}