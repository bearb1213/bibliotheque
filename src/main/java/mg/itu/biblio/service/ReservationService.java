package mg.itu.biblio.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mg.itu.biblio.repository.TypeReservationRepository;
import mg.itu.biblio.repository.TypeAdhesionRepository;
import mg.itu.biblio.repository.ReservationRepository;
import mg.itu.biblio.repository.QuotaRepository;

import mg.itu.biblio.model.Exemplaire;
import mg.itu.biblio.model.TypeReservation;
import mg.itu.biblio.model.Reservation;
import mg.itu.biblio.model.Utilisateur;
import mg.itu.biblio.model.Adhesion;
import mg.itu.biblio.model.Quota;

@Service
public class ReservationService {

    @Autowired
    private TypeReservationRepository typeReservationRepository;

    @Autowired
    private AdhesionService adhesionService;

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired 
    private TypeAdhesionRepository typeAdhesionRepository;
    
    @Autowired 
    private QuotaRepository quotaRepository;


    public Reservation reserver(Utilisateur utilisateur,Exemplaire exemplaire,LocalDate date)throws Exception{
        Adhesion adhesion = adhesionService.getAdherent(utilisateur, LocalDate.now());
        if (adhesion == null) {
            throw new Exception("Vous n'etet plus abonner");
        } 
        int nbReservation = reservationRepository.countByUtilisateurAndDateAcceptIsNullAndDateRefusIsNull(utilisateur);
        Quota quota = quotaRepository.findByActionAndTypeAdhesion("reservation", adhesion.getTypeAdhesion()).get(0);
        if (nbReservation>=quota.getQuota()){
            throw new Exception("Vous avez atteint votre quota");
        }
        TypeReservation typeReservation = typeReservationRepository.findById(1).orElse(null); 
        Reservation reservation = new Reservation(null,date,LocalDate.now(),null,null,typeReservation,utilisateur,exemplaire);
        reservationRepository.save(reservation);

        return reservation;
    }

    public Reservation accepter(Reservation reservation){
        reservation.setDateAccept(LocalDate.now());
        reservationRepository.save(reservation);
        return reservation;
    }

    public Reservation refuser(Reservation reservation){
        reservation.setDateRefus(LocalDate.now());
        reservationRepository.save(reservation);
        return reservation;
    }

    public Reservation findById(Integer id){
        return reservationRepository.findById(id).orElse(null);
    }
    public List<Reservation> findAllReservations(){
        TypeReservation type = typeReservationRepository.findById(1).orElse(null);
        return reservationRepository.findByTypeAndDateAcceptIsNullAndDateRefusIsNull(type);
    }
}
