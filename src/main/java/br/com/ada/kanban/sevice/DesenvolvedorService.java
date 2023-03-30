package br.com.ada.kanban.sevice;

import br.com.ada.kanban.domain.Desenvolvedor;
import br.com.ada.kanban.exceptions.DesenvolvedorNotFoundException;
import br.com.ada.kanban.repository.DesenvolvedorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
public class DesenvolvedorService implements IDesenvolvedorService{

    private final DesenvolvedorRepository repository;
    @Override
    public List<Desenvolvedor> list() {
        return (List<Desenvolvedor>) repository.findAll();
    }

    @Override
    public Desenvolvedor save(Desenvolvedor desenvolvedor) {
        if(!repository.existsById(desenvolvedor.getId())){
            repository.save(desenvolvedor);
        }
        throw new DesenvolvedorNotFoundException();
    }

    @Override
    public Desenvolvedor findById(Long id) {
        return repository.findById(id).orElseThrow(DesenvolvedorNotFoundException::new);
    }

    @Override
    public Desenvolvedor update(Long id, Desenvolvedor desenvolvedor) {
        if(repository.existsById(id)){
            desenvolvedor.setId(id);
            return repository.save(desenvolvedor);
        }
        throw new DesenvolvedorNotFoundException();
    }


    @Override
    public void delete(Long id) {
        if(!repository.existsById(id)){
            throw new DesenvolvedorNotFoundException();
        }
        repository.deleteById(id);
    }
}
