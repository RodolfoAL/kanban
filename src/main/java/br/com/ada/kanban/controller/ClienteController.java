package br.com.ada.kanban.controller;


import br.com.ada.kanban.domain.Cliente;
import br.com.ada.kanban.dto.ClienteDTO;
import br.com.ada.kanban.service.ClienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping ("clientes")
@RestController
public class ClienteController {

    private final ClienteService clienteService;


    @GetMapping
    public List<Cliente> list() {
        return clienteService.list();
    }

    @GetMapping ("{id}")
    public Cliente findById(@PathVariable Long id) {
        return clienteService.findById(id);
    }

    @PostMapping
    @ResponseStatus (HttpStatus.CREATED)
    public Cliente save(@Valid @RequestBody ClienteDTO dto) {
        Cliente cliente = builderCliente(dto);
        return clienteService.save(cliente);
    }

    @PutMapping ("{id}")
    public Cliente update(@Valid @PathVariable Long id, @RequestBody ClienteDTO dto) {
        Cliente cliente = builderCliente(dto);
        return clienteService.update(id, cliente);
    }

    @DeleteMapping ("{id}")
    public void delete(@PathVariable Long id) {
        clienteService.delete(id);
    }

    public Cliente builderCliente(ClienteDTO dto){
        Cliente cliente = Cliente.builder()
                .nome(dto.getNome())
                .empresa(dto.getEmpresa())
                .telefone(dto.getTelefone()).build();
        return cliente;
    }
}
