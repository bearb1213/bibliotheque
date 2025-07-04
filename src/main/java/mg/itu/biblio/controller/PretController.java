package mg.itu.biblio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import mg.itu.biblio.model.Exemplaire;
import mg.itu.biblio.model.Livre;
import mg.itu.biblio.model.Pret;
import mg.itu.biblio.model.TypePret;
import mg.itu.biblio.model.Utilisateur;
import mg.itu.biblio.repository.*;
import mg.itu.biblio.service.*;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.RequestAttribute;

@Controller
@RequestMapping("/pret")
public class PretController {
    @Autowired
    private PretService pretService;

    @Autowired
    private LivreService livreService;

    @Autowired
    private UtilisateurRepository utilisateurRepository;
    
    @Autowired
    private ExemplaireRepository exemplaireRepository;

    @Autowired
    private TypePretRepository typePretRepository;

    
    @PostMapping("/p")
    public String preter(@RequestParam("id") String id,
                        @RequestParam("email") String email,
                        @RequestParam("mdp") String mdp,
                        @RequestParam("idType") String idType,
                        HttpSession session, Model model 
    ){
        try {
            if(id.isEmpty() || email.isEmpty() || mdp.isEmpty() || idType.isEmpty() ){
                throw new Exception("Identifiant incomplet");
            }
            Integer idUser = (Integer) session.getAttribute("utilisateurId");
            Integer type = (Integer) session.getAttribute("utilisateurType");
             if(idUser==null){
                return  "redirect:/sign/";
            }
            if(type!=2){
                return  "redirect:/sign/";
            }
            Utilisateur utilisateur = utilisateurRepository.findByEmailAndMotDePasse(email, mdp);
            if(utilisateur==null){
                throw new Exception("Identifiant incorrecte");
            }
            Integer idEx = Integer.parseInt(id);
            Exemplaire exemplaire = exemplaireRepository.findById(idEx).orElse(null); 
            if(exemplaire==null){
                throw new Exception("Exemplaire Inexistant");
            }
            TypePret typePret = typePretRepository.findById(Integer.parseInt(idType)).orElse(null); 
            if(typePret==null){
                throw new Exception("Type de pret innexistant");
            }
            Pret pret = pretService.preter(utilisateur, exemplaire, typePret);
            
            return "redirect:/";

        } catch (Exception e){
            
            model.addAttribute("message" , e.getMessage());
            e.printStackTrace();
        }
        Livre livre = livreService.getById(Integer.parseInt(id));
        model.addAttribute("livre" , livre);
        model.addAttribute("utilisateurType",(Integer)session.getAttribute("utilisateurType"));
        model.addAttribute("utilisateurId",(Integer)session.getAttribute("utilisateurId"));
        
        return "livre/livre";
        
    }


    @GetMapping("/p/{id}")
    public String pretForm(@PathVariable("id") String id , Model model,HttpSession session){
        try {
            Integer idUser = (Integer) session.getAttribute("utilisateurId");
            Integer type = (Integer) session.getAttribute("utilisateurType");
            if(idUser==null){
                return  "redirect:/sign/";
            }
            if(type!=2){
                return  "redirect:/sign/";
            }
            Utilisateur utilisateur = utilisateurRepository.findById(idUser).orElse(null);
            if(utilisateur==null){
                return  "redirect:/sign/";
            }
            Integer idEx = Integer.parseInt(id);
            Exemplaire exemplaire = exemplaireRepository.findById(idEx).orElse(null); 
            if(exemplaire==null){
                throw new Exception("Exemplaire Inexistant");
            }
            model.addAttribute("id",id) ;
            model.addAttribute("type",typePretRepository.findAll());
            return "pret/form";
        } catch (Exception e) {
            model.addAttribute("message" , e.getMessage());
            e.printStackTrace();
            Livre livre = livreService.getById(Integer.parseInt(id));
            model.addAttribute("livre" , livre);
            model.addAttribute("utilisateurType",(Integer)session.getAttribute("utilisateurType"));
            model.addAttribute("utilisateurId",(Integer)session.getAttribute("utilisateurId"));

            return "livre/livre";
        }
    }

    @GetMapping("/")
    public String listPret(Model model , HttpSession session){
        try{
            Integer idUser = (Integer) session.getAttribute("utilisateurId");
            Integer type = (Integer) session.getAttribute("utilisateurType");
            if(idUser==null){
                return  "redirect:/sign/";
            }
            if(type!=2){
                return  "redirect:/sign/";
            }
            Utilisateur utilisateur = utilisateurRepository.findById(idUser).orElse(null);
            if(utilisateur==null){
                return  "redirect:/sign/";
            }
            model.addAttribute("prets",pretService.findAll());


        } catch(Exception e){
            model.addAttribute("message",e.getMessage());
        }
        return "pret/liste";
    }
    @GetMapping("/r/{id}")
    public String rendre(@PathVariable("id") String id ,Model model,HttpSession session){
        try{
            Integer idUser = (Integer) session.getAttribute("utilisateurId");
            Integer type = (Integer) session.getAttribute("utilisateurType");
            if(idUser==null){
                return  "redirect:/sign/";
            }
            if(type!=2){
                return  "redirect:/sign/";
            }
            Utilisateur utilisateur = utilisateurRepository.findById(idUser).orElse(null);
            if(utilisateur==null){
                return  "redirect:/sign/";
            }
            model.addAttribute("id" , id);

        }catch (Exception e){
            e.printStackTrace();
        }
        return "pret/formRendre";
    }

    @PostMapping("/r")
    public String rendreDate(@RequestParam("id") String id,
                            @RequestParam("date") String date,
                            Model model,HttpSession session
    ){
        try {

            Integer idUser = (Integer) session.getAttribute("utilisateurId");
            Integer type = (Integer) session.getAttribute("utilisateurType");
            if(idUser==null){
                return  "redirect:/sign/";
            }
            if(type!=2){
                return  "redirect:/sign/";
            }
            Utilisateur utilisateur = utilisateurRepository.findById(idUser).orElse(null);
            if(utilisateur==null){
                return  "redirect:/sign/";
            }
            Pret pret = pretService.findById(Integer.parseInt(id));
            pretService.rendre(pret, LocalDate.parse(date));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/pret/";
    }

    
}
