package br.com.ada.kanban.mapper;

import br.com.ada.kanban.domain.Desenvolvedor;
import br.com.ada.kanban.dto.DesenvolvedorDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DesenvolvedorMapper {

    @Mapping(target = "tarefa", ignore = true)
    Desenvolvedor desenvolvedorDTOToDesenvolvedor(DesenvolvedorDTO dto);
}
