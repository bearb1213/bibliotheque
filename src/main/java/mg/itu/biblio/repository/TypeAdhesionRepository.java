package mg.itu.biblio.repository;

import mg.itu.biblio.model.TypeAdhesion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface  TypeAdhesionRepository extends JpaRepository<TypeAdhesion, Integer>{
    
}
