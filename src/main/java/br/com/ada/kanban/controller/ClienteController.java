package br.com.ada.kanban.controller;


import br.com.ada.kanban.domain.Cliente;
import br.com.ada.kanban.dto.ClienteDTO;
import br.com.ada.kanban.service.ClienteServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping ("clientes")
@RestController
public class ClienteController {

    private final ClienteServiceImpl clienteServiceImpl;

    @GetMapping
    public List<Cliente> list() {
        return clienteServiceImpl.list();
    }

    @GetMapping ("{id}")
    public Cliente findById(@PathVariable Long id) {
        return clienteServiceImpl.findById(id);
    }

    @PostMapping
    @ResponseStatus (HttpStatus.CREATED)
    public Cliente save(@Valid @RequestBody ClienteDTO dto) {
        Cliente cliente = Cliente.builder()
                .nome(dto.getNome())
                .empresa(dto.getEmpresa())
                .telefone(dto.getTelefone())
                .build();
        return clienteServiceImpl.save(cliente);
    }

    @PutMapping ("{id}")
    public Cliente update(@Valid @PathVariable Long id, @RequestBody ClienteDTO dto) {
        Cliente cliente = Cliente.builder()
                .nome(dto.getNome())
                .empresa(dto.getEmpresa())
                .telefone(dto.getTelefone())
                .build();
        return clienteServiceImpl.update(id, cliente);
    }

    @DeleteMapping ("{id}")
    public void delete(@PathVariable Long id) {
        clienteServiceImpl.delete(id);
    }

}
