package br.com.ada.kanban.sevice;

import br.com.ada.carloca.domain.Cliente;
import br.com.ada.carloca.dto.ClienteDTO;
import br.com.ada.kanban.domain.Cliente;
import br.com.ada.kanban.dto.ClienteDTO;

import java.util.List;

public interface ClienteServiceInterface {

    List<Cliente> list();
    Cliente findById(Long id);
    Cliente save(Cliente cliente);
    void delete(Long id);
    Cliente update(Long id, ClienteDTO dto);
}
