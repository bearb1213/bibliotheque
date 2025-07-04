package mg.itu.biblio.repository;

import mg.itu.biblio.model.PenaliteType;
import mg.itu.biblio.model.TypeAdhesion;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PenaliteTypeRepository extends JpaRepository<PenaliteType, Integer> {
    List<PenaliteType> findByType(TypeAdhesion type);
}
