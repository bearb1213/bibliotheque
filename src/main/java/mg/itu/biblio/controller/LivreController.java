package mg.itu.biblio.controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import mg.itu.biblio.service.LivreService;
import mg.itu.biblio.model.Livre;

import java.util.List;

@Controller
public class LivreController {
    @Autowired
    private LivreService livreService;

    @GetMapping("/")
    public String accueil(Model model,HttpSession session) {
        List<Livre> livres = livreService.getAll();
        Integer utilisateurType = (Integer)session.getAttribute("utilisateurType");
        model.addAttribute("livres", livres);
        model.addAttribute("utilisateurType", utilisateurType);
        return "livre/catalogue";
    }

    @GetMapping("/l/{id}")
    public String livre(@PathVariable("id") String id, HttpSession session,Model model ){
        Livre livre = livreService.getById(Integer.parseInt(id));
        model.addAttribute("livre" , livre);
        model.addAttribute("utilisateurType",(Integer)session.getAttribute("utilisateurType"));
        model.addAttribute("utilisateurId",(Integer)session.getAttribute("utilisateurId"));
        
        return "livre/livre";
    }
}
