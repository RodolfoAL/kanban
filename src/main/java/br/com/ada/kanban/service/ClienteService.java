package br.com.ada.kanban.service;

import br.com.ada.kanban.domain.Cliente;

import java.util.List;

public interface ClienteService {

    List<Cliente> list();
    Cliente findById(Long id);
    Cliente save(Cliente cliente);
    void delete(Long id);
    Cliente update(Long id, Cliente cliente);
}
