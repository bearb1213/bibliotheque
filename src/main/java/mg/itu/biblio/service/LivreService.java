package mg.itu.biblio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mg.itu.biblio.model.Livre;
import mg.itu.biblio.repository.LivreRepository;
import java.util.List;

@Service
public class LivreService {
    @Autowired
    LivreRepository livreRepository;

    public List<Livre> getAll(){
        return livreRepository.findAllWithGenres();
    }
    public Livre getById(Integer id){
        return livreRepository.findByIdWithGenres(id);
    }
}
