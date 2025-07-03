package mg.itu.biblio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
// @RequestMapping("/")
public class AccueilController {

    @GetMapping("/accueil")
    public String accueil(Model model) {
        model.addAttribute("nom", "Rakotoson");
        List<String> maListe = Arrays.asList("Article 1", "Article 2", "Article 3");
        model.addAttribute("liste", maListe);
        return "test"; 
    }
}
