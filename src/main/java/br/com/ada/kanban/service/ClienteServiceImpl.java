package br.com.ada.kanban.service;

import br.com.ada.kanban.domain.Cliente;
import br.com.ada.kanban.exceptions.ClienteAlreadyExistsException;
import br.com.ada.kanban.exceptions.ClienteNotFoundException;
import br.com.ada.kanban.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository repository;

    @Override
    public List<Cliente> list() {
        return (List<Cliente>) repository.findAll();
    }

    @Override
    public Cliente findById(Long id) {
        return repository.findById(id).orElseThrow(ClienteNotFoundException::new);
    }

    @Override
    public Cliente save(Cliente cliente) {
        if(!repository.existsById(cliente.getId())){
            repository.save(cliente);
        }
        throw new ClienteAlreadyExistsException();
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ClienteNotFoundException();
        }
        repository.deleteById(id);
    }

    @Override
    public Cliente update(Long id, Cliente cliente) {
        if(repository.existsById(id)){
            cliente.setId(id);
            return repository.save(cliente);
        }
        throw new ClienteNotFoundException();
    }


}
