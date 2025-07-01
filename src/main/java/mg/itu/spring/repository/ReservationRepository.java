package mg.itu.spring.repository;

import mg.itu.spring.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

    // Trouver les réservations d'un adhérent
    List<Reservation> findByAdherentId(Integer adherentId);

    // Trouver les réservations pour un exemplaire
    List<Reservation> findByExemplaireId(Integer exemplaireId);

    // Trouver les réservations par statut
    List<Reservation> findByStatutId(Integer statutId);

    // Trouver les réservations actives
    @Query("SELECT r FROM Reservation r WHERE r.statut.nomStatut = 'Actif'")
    List<Reservation> findActiveReservations();

    // Trouver les réservations modifiées après une certaine date
    List<Reservation> findByDateChangementAfter(Date date);

    // Charger une réservation avec toutes ses relations
    @Query("SELECT DISTINCT r FROM Reservation r " +
           "LEFT JOIN FETCH r.exemplaire " +
           "LEFT JOIN FETCH r.statut " +
           "LEFT JOIN FETCH r.adherent " +
           "WHERE r.id = :id")
    Optional<Reservation> findByIdWithDetails(@Param("id") Integer id);

    // Statistiques des réservations
    @Query("SELECT r.statut.nomStatut, COUNT(r) FROM Reservation r GROUP BY r.statut")
    List<Object[]> countReservationsByStatus();
}