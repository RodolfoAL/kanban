package br.com.ada.kanban.controller;

import br.com.ada.kanban.domain.Tarefa;
import br.com.ada.kanban.dto.TarefaDTO;
import br.com.ada.kanban.service.TarefaServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("tarefas")
@RestController
public class TarefaController {

    private final TarefaServiceImpl tarefaService;

    @GetMapping("{id}")
    public Tarefa findById (@PathVariable Long id){
        return tarefaService.findById(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Tarefa save(@Valid @RequestBody TarefaDTO dto){
        Tarefa tarefa = Tarefa.builder()
                .titulo(dto.getTitulo())
                .descricao(dto.getDescricao())
                .desenvolvedor(dto.getDesenvolvedor())
                .cliente(dto.getCliente())
                .status(dto.getStatus())
                .build();
        return tarefaService.save(tarefa);
        }


    public Tarefa update(@Valid @PathVariable Long id, @RequestBody TarefaDTO dto){
        Tarefa tarefa = Tarefa.builder()
                .titulo(dto.getTitulo())
                .descricao(dto.getDescricao())
                .desenvolvedor(dto.getDesenvolvedor())
                .cliente(dto.getCliente())
                .status(dto.getStatus())
                .build();
        return tarefaService.update(id, tarefa);
    }

    @DeleteMapping ("{id}")
    public void delete(@PathVariable Long id) {
        tarefaService.delete(id);
    }

}
