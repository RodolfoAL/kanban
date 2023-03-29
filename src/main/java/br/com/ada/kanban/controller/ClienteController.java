package br.com.ada.kanban.controller;


import br.com.ada.kanban.domain.Cliente;
import br.com.ada.kanban.dto.ClienteDTO;
import br.com.ada.kanban.sevice.ClienteServiceInterface;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteServiceInterface clienteServiceInterface;

    @GetMapping
    public List<Cliente> list() {
        return clienteServiceInterface.list();
    }

    @GetMapping ("{id}")
    public Cliente findById(@PathVariable Long id) {
        return clienteServiceInterface.findById(id);
    }

    @PostMapping
    @ResponseStatus (HttpStatus.CREATED)
    public Cliente save(@Valid @RequestBody Cliente cliente) {
        return clienteServiceInterface.save(cliente);
    }

    @DeleteMapping ("{id}")
    public void delete(@PathVariable Long id) {
        clienteServiceInterface.delete(id);
    }

    @PutMapping ("{id}")
    public Cliente update(@Valid @PathVariable Long id, @RequestBody ClienteDTO dto) {
        return clienteServiceInterface.update(id, dto);
    }

}
