package mg.itu.biblio.repository;

import mg.itu.biblio.model.Reservation;
import mg.itu.biblio.model.TypeReservation;
import mg.itu.biblio.model.Utilisateur;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    
    int countByUtilisateurAndDateAcceptIsNullAndDateRefusIsNull(Utilisateur utilisateur);
    List<Reservation> findByTypeAndDateAcceptIsNullAndDateRefusIsNull(TypeReservation type);

}
