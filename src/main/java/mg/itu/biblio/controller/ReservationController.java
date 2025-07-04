package mg.itu.biblio.controller;

import jakarta.servlet.http.HttpSession;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import mg.itu.biblio.model.Exemplaire;
import mg.itu.biblio.model.Livre;
import mg.itu.biblio.service.ReservationService;
import mg.itu.biblio.service.LivreService;
import mg.itu.biblio.repository.UtilisateurRepository;
import mg.itu.biblio.repository.ExemplaireRepository;

import mg.itu.biblio.model.Exemplaire;
import mg.itu.biblio.model.Reservation;
import mg.itu.biblio.model.TypeReservation;
import mg.itu.biblio.model.Utilisateur;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/reserver")
public class ReservationController {
    @Autowired 
    private ReservationService reservationService;

    @Autowired 
    private LivreService livreService;


    @Autowired 
    private UtilisateurRepository utilisateurRepository;
    
    @Autowired 
    private ExemplaireRepository exemplaireRepository;
    
    @GetMapping("/")
    public String listReservations(Model model) {
        List<Reservation> reservations = reservationService.findAllReservations();
        model.addAttribute("reservations", reservations);
        return "reservation/liste"; // le nom de ton fichier Thymeleaf
    }
    @PostMapping("/r")
    public String reserverr(@RequestParam("id") String id , 
                            @RequestParam("date") String date,
                            HttpSession session,
                            Model model){
        
        try {
            Integer idUser = (Integer) session.getAttribute("utilisateurId");
            if(idUser==null){
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
            LocalDate localDate = LocalDate.parse(date);
            if(localDate.isBefore(LocalDate.now())){
                throw new Exception("Date ne peux pas etre dans le passer");
            }
            Reservation reservation = reservationService.reserver(utilisateur, exemplaire,localDate );    
            model.addAttribute("message" , "Reservation reussi");
        } catch (Exception e) {
            model.addAttribute("message" , e.getMessage());
            e.printStackTrace();
        }
        Livre livre = livreService.getById(Integer.parseInt(id));
        model.addAttribute("livre" , livre);
        model.addAttribute("utilisateurType",(Integer)session.getAttribute("utilisateurType"));
        model.addAttribute("utilisateurId",(Integer)session.getAttribute("utilisateurId"));
        
        return "livre/livre";
        
    }

    @GetMapping("/r/{id}")
    public String reserver(@PathVariable("id") String id , Model model,HttpSession session){
        
        try {
            Integer idUser = (Integer) session.getAttribute("utilisateurId");
            if(idUser==null){
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
            return "reservation/form";
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

    @GetMapping("/accepter/{id}")
    public String accepter(@PathVariable("id") String id,Model model){
        try{
            Reservation reservation = reservationService.findById(Integer.parseInt(id));
            reservationService.accepter(reservation);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/reserver/";
    } 

    
    @GetMapping("/refuser/{id}")
    public String refuser(@PathVariable("id") String id,Model model){
        try{
            Reservation reservation = reservationService.findById(Integer.parseInt(id));
            reservationService.refuser(reservation);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/reserver/";
    } 


}
