package br.com.ada.kanban.service;

import br.com.ada.kanban.domain.Cliente;
import br.com.ada.kanban.domain.Status;
import br.com.ada.kanban.domain.Tarefa;
import br.com.ada.kanban.exceptions.ClienteAlreadyExistsException;
import br.com.ada.kanban.exceptions.ClienteNotFoundException;
import br.com.ada.kanban.exceptions.TarefaAlreadyExistsException;
import br.com.ada.kanban.exceptions.TarefaNotFoundException;
import br.com.ada.kanban.repository.TarefaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TarefaServiceImpl implements TarefaService {

    private final TarefaRepository repository;

    @Override
    public List<Tarefa> list() {
        return (List<Tarefa>) repository.findAll();
    }

    @Override
    public Tarefa findById(Long id) {
        return repository.findById(id).orElseThrow(TarefaNotFoundException::new);
    }

    @Override
    public Tarefa save(Tarefa tarefa) {
        tarefa.setStatus(Status.TO_DO);
        return repository.save(tarefa);
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new TarefaNotFoundException();
        }
        repository.deleteById(id);
    }

    @Override
    public Tarefa update(Long id, Tarefa tarefa) {
        if(repository.existsById(id)){
            tarefa.setId(id);
            return repository.save(tarefa);
        }
        throw new TarefaNotFoundException();
    }

}
