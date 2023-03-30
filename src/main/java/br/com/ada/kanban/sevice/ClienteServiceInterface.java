package br.com.ada.kanban.sevice;

import br.com.ada.kanban.domain.Cliente;

import java.util.List;

public interface ClienteServiceInterface {

    List<Cliente> list();
    Cliente findById(Long id);
    Cliente save(Cliente cliente);
    void delete(Long id);
    Cliente update(Long id, Cliente cliente);
}
