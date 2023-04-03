package br.com.ada.kanban.controller;

import br.com.ada.kanban.domain.Desenvolvedor;
import br.com.ada.kanban.domain.Tarefa;
import br.com.ada.kanban.dto.DesenvolvedorDTO;
import br.com.ada.kanban.service.DesenvolvedorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@RequestMapping("desenvolvedores")
@RestController
public class DesenvolvedorController {

    private final DesenvolvedorService desenvolvedorService;


    @GetMapping
    public List<Desenvolvedor> list(){
        return desenvolvedorService.list();
    }

    @GetMapping("{id}")
    public Desenvolvedor findById(@PathVariable Long id ){
        return desenvolvedorService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Desenvolvedor save(@Valid @RequestBody DesenvolvedorDTO dto) {
        Desenvolvedor desenvolvedor = buildDesenvolvedor(dto);
        return desenvolvedorService.save(desenvolvedor);
    }

    @PutMapping("{id}")
    public Desenvolvedor update(@Valid @PathVariable Long id, @RequestBody DesenvolvedorDTO dto) {
        Desenvolvedor desenvolvedor = buildDesenvolvedor(dto);
        return desenvolvedorService.update(id, desenvolvedor);
    }

    @DeleteMapping ("{id}")
    public void delete(@PathVariable Long id) {
        desenvolvedorService.delete(id);
    }

    public Desenvolvedor buildDesenvolvedor(DesenvolvedorDTO dto){
        Desenvolvedor desenvolvedor = Desenvolvedor.builder()
                .nome(dto.getNome())
                .tarefa((Set<Tarefa>) dto.getTarefa())
                .build();
        return desenvolvedor;
    }
}
