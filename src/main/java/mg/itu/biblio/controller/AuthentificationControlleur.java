package mg.itu.biblio.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import mg.itu.biblio.model.Utilisateur;
import mg.itu.biblio.model.Adhesion;
import mg.itu.biblio.model.UtilisateurType;
import mg.itu.biblio.service.AuthentificationService;
        
import java.util.ArrayList;
@Controller
@RequestMapping("/sign")
public class AuthentificationControlleur {
 
    @Autowired
    private AuthentificationService authentificationService;

    
    @GetMapping("/")
    public String loginForm(Model model) {
        return "utilisateur/login";
    }
    @PostMapping("/")
    public String login(@RequestParam("email") String email,                    
                        @RequestParam("mdp") String mdp,
                        HttpSession session,
                        Model model 
    ){
        try{

            Utilisateur utilisateur = authentificationService.findUtilisateur(email, mdp);
            if (email.isEmpty() || mdp.isEmpty()){
                model.addAttribute("message", "Email ou mot de passe incomplet.");
                return "utilisateur/login";
            }
            if (utilisateur != null) {
                session.setAttribute("utilisateurId", utilisateur.getId());
                session.setAttribute("utilisateurType" , utilisateur.getUtilisateurType().getId()); 
                return "redirect:/";    
            } else {
                model.addAttribute("message", "Email ou mot de passe incorrect.");
                return "utilisateur/login";
            }
            
        } catch (Exception e){
            model.addAttribute("message", e.getMessage());
            return "utilisateur/login" ;            
        }
    }   

    @GetMapping("/in")
    public String showCreateForm(Model model) {
        return "utilisateur/sign"; 
    }

    @PostMapping("/in")
    public String create(   @RequestParam("nom") String nom,
                        @RequestParam("email") String email,                    
                        @RequestParam("mdp") String mdp,
                        Model model
                        ) {
        if (email.isEmpty() || mdp.isEmpty() || nom.isEmpty()){
            model.addAttribute("message", "Email ou mot de passe incomplet.");
            return "utilisateur/sign";
        } 
        Utilisateur userTest = authentificationService.findUtilisateur(email);
        if (userTest!=null){
            model.addAttribute("message", "Email Deja utiliser");
            return "utilisateur/sign";
        }
        Utilisateur utilisateur = new Utilisateur(null, nom, email, mdp,authentificationService.getTypeById(1),new ArrayList<Adhesion>() );
        authentificationService.createUtilisateur(utilisateur);
        return "redirect:/sign/in"; 
    }

}
