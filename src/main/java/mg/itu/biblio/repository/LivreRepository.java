package mg.itu.biblio.repository;

import mg.itu.biblio.model.Livre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;


public interface  LivreRepository extends JpaRepository<Livre, Integer>{
    @Query("SELECT l FROM Livre l LEFT JOIN FETCH l.genres WHERE l.id = :id")
    Livre findByIdWithGenres(@Param("id") Integer id);

    @Query("SELECT DISTINCT l FROM Livre l LEFT JOIN FETCH l.genres")
    List<Livre> findAllWithGenres();
}
