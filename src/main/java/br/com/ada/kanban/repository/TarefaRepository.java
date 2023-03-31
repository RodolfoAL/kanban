package br.com.ada.kanban.repository;

import br.com.ada.kanban.domain.Tarefa;
import org.springframework.data.repository.CrudRepository;

public interface TarefaRepository extends CrudRepository<Tarefa, Long> {
}
