package mg.itu.biblio.repository;

import mg.itu.biblio.model.TypePret;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface  TypePretRepository extends JpaRepository<TypePret, Integer>{
    
}
