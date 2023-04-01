package br.com.ada.kanban.mapper;

import br.com.ada.kanban.domain.Cliente;
import br.com.ada.kanban.dto.ClienteDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel  = "spring")
public interface ClienteMapper {


    @Mapping(target = "pedidos", ignore = true)
    Cliente  clienteDTOToCliente(ClienteDTO dto);


}
