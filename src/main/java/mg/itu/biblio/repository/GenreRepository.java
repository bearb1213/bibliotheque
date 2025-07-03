package mg.itu.biblio.repository;

import mg.itu.biblio.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre , Integer>{
    
}
