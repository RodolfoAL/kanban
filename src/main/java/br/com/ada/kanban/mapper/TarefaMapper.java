package br.com.ada.kanban.mapper;

import br.com.ada.kanban.domain.Tarefa;
import br.com.ada.kanban.dto.TarefaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TarefaMapper {

    @Mapping(target = "desenvolvedor", ignore = true)
    Tarefa tarefaDTOToTarefa(TarefaDTO dto);
}
