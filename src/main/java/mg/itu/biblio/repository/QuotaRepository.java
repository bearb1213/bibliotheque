package mg.itu.biblio.repository;

import mg.itu.biblio.model.Quota;
import mg.itu.biblio.model.TypeAdhesion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface  QuotaRepository extends JpaRepository<Quota, Integer>{
    List<Quota> findByActionAndTypeAdhesion(String action, TypeAdhesion typeAdhesion);
   
}
