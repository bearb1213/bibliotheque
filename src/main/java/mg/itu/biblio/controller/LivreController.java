package mg.itu.biblio.controller;

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
    public String accueil(Model model) {
        List<Livre> livres = livreService.getAll();
        model.addAttribute("livres", livres);
        return "catalogue";
    }
}
