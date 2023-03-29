package br.com.ada.kanban.sevice;

import br.com.ada.carloca.domain.Cliente;
import br.com.ada.carloca.dto.ClienteDTO;
import br.com.ada.carloca.exceptions.ClienteAlreadyExistsException;
import br.com.ada.carloca.exceptions.ClienteNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ClienteService implements ClienteServiceInterface {

    List<Cliente> clientes = new ArrayList<>();

    @Override
    public List<Cliente> list() {
        return clientes;
    }

    @Override
    public Cliente findById(Long id) {
        clientes.stream()
                .filter(cliente -> cliente.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ClienteNotFoundException());
        return null;
    }

    @Override
    public Cliente save(Cliente cliente) {
        Optional<Cliente> clienteJaCadastrado = Optional.of(clientes.stream()
                .filter(clienteX -> clienteX.getCpf() == cliente.getCpf())
                .findFirst()
                .get());
        try {
            if (clienteJaCadastrado == null) {

                cliente.setId(clientes.size() + 1L);
                clientes.add(cliente);
            }
        } catch (ClienteAlreadyExistsException e) {
            e.getMessage();
        }
                return cliente;
    }

    @Override
    public void delete(Long id) {
        //Cliente cliente = findById(id);
        if ((findById(id)) != null) {
            this.clientes.removeIf(clienteX -> clienteX.getId() == id);
        }
        //clientes.remove(cliente);
    }

    @Override
    public Cliente update(Long id, ClienteDTO dto) {
        Optional<Cliente> clienteEditado = clientes.stream()
                .filter(x -> x.getId() == id)
                .findAny();
        Cliente cliente = findById(id);
        //int index = clientes.indexOf(cliente);
        if (clienteEditado.isPresent()) {
            this.clientes.stream()
                    .filter(x -> x.getId() == id)
                    .findFirst()
                    .get().setNome(dto.getNome());
            this.clientes.stream()
                    .filter(x -> x.getId() == id)
                    .findFirst()
                    .get().setCpf(dto.getCpf());
            this.clientes.stream()
                    .filter(x -> x.getId() == id)
                    .findFirst()
                    .get().setCnh(dto.getCnh());
       /* cliente = Cliente.builder()
                .nome(dto.getNome())
                .cpf(dto.getCpf())
                .cnh(dto.getCnh())
                .build();*/
        }
        //clientes.set(index, cliente);
        return cliente;
    }
}
