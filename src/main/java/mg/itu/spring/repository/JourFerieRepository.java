package mg.itu.spring.repository;

import mg.itu.spring.model.JourFerie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface JourFerieRepository extends JpaRepository<JourFerie, Integer> {

    Optional<JourFerie> findByDateJourFerie(Date date);

    boolean existsByDateJourFerie(Date date);

    @Query("SELECT j FROM JourFerie j WHERE j.dateJourFerie BETWEEN :start AND :end ORDER BY j.dateJourFerie")
    List<JourFerie> findBetweenDates(@Param("start") Date start, @Param("end") Date end);

    @Query("SELECT j FROM JourFerie j WHERE FUNCTION('YEAR', j.dateJourFerie) = :year ORDER BY j.dateJourFerie")
    List<JourFerie> findByYear(@Param("year") int year);
}