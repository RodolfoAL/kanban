package br.com.ada.kanban.service;

import br.com.ada.kanban.domain.Desenvolvedor;
import br.com.ada.kanban.domain.Tarefa;

import java.util.List;

public interface TarefaService {

    List<Tarefa> list();
    Tarefa save( Tarefa tarefa);
    Tarefa findById(Long id);
    Tarefa update(Long id, Tarefa tarefa);

    void delete(Long id);

}
