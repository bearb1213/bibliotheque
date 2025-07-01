package mg.itu.spring.repository;

import mg.itu.spring.model.TypeMembre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import  java.util.*;

@Repository
public interface TypeMembreRepository extends JpaRepository<TypeMembre, Integer> {
    
    @Query("SELECT tm FROM TypeMembre tm LEFT JOIN FETCH tm.cotisations WHERE tm.id = :id")
    Optional<TypeMembre> findByIdWithCotisations(@Param("id") Integer id);

    @Query("SELECT DISTINCT tm FROM TypeMembre tm LEFT JOIN FETCH tm.cotisations")
    List<TypeMembre> findAllWithCotisations();

    @Query("SELECT DISTINCT tm FROM TypeMembre tm LEFT JOIN FETCH tm.adherents WHERE tm.id = :id")
    Optional<TypeMembre> findByIdWithAdherents(@Param("id") Integer id);

    @Query("SELECT DISTINCT tm FROM TypeMembre tm LEFT JOIN FETCH tm.adherents")
    List<TypeMembre> findAllWithAdherents();

    @Query("SELECT DISTINCT tm FROM TypeMembre tm " +
           "LEFT JOIN FETCH tm.adherents " +
           "LEFT JOIN FETCH tm.cotisations " +
           "WHERE tm.id = :id")
    Optional<TypeMembre> findByIdWithAdherentsAndCotisations(@Param("id") Integer id);

    
    @Query("SELECT DISTINCT tm FROM TypeMembre tm " +
           "LEFT JOIN FETCH tm.adherents " +
           "LEFT JOIN FETCH tm.cotisations ")
    List<TypeMembre> findByIdWithAdherentsAndCotisations();

}