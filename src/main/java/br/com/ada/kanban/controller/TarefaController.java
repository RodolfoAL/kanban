package br.com.ada.kanban.controller;

import br.com.ada.kanban.domain.Cliente;
import br.com.ada.kanban.domain.Tarefa;
import br.com.ada.kanban.dto.TarefaDTO;
import br.com.ada.kanban.service.TarefaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("tarefas")
@RestController
public class TarefaController {

    private final TarefaService tarefaService;

    @GetMapping
    public List<Tarefa> list() {
        return tarefaService.list();
    }

    @GetMapping("{id}")
    public Tarefa findById (@PathVariable Long id){
        return tarefaService.findById(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Tarefa save(@Valid @RequestBody TarefaDTO dto){
        Tarefa tarefa = buildTarefa(dto);
        return tarefaService.save(tarefa);
        }

    @PutMapping("{id}")
    public Tarefa update(@Valid @PathVariable Long id, @RequestBody TarefaDTO dto){
        Tarefa tarefa = buildTarefa(dto);
        return tarefaService.update(id, tarefa);
    }

    @DeleteMapping ("{id}")
    public void delete(@PathVariable Long id) {
        tarefaService.delete(id);
    }

    public Tarefa buildTarefa(TarefaDTO dto){
        Cliente cliente = new Cliente();
        cliente.setId(dto.getClienteId());
        Tarefa tarefa = Tarefa.builder()
                .titulo(dto.getTitulo())
                .descricao(dto.getDescricao())
                .cliente(cliente)
                .build();
        return tarefa;
    }

}
