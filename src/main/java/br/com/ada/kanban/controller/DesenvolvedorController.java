package br.com.ada.kanban.controller;

import br.com.ada.kanban.domain.Desenvolvedor;
import br.com.ada.kanban.dto.DesenvolvedorDTO;
import br.com.ada.kanban.mapper.DesenvolvedorMapper;
import br.com.ada.kanban.service.DesenvolvedorServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("desenvolvedores")
@RestController
public class DesenvolvedorController {

    private final DesenvolvedorServiceImpl desenvolvedorServiceImpl;

    private final DesenvolvedorMapper mapper;

    @GetMapping
    public List<Desenvolvedor> list(){
        return desenvolvedorServiceImpl.list();
    }

    @GetMapping("{id}")
    public Desenvolvedor findById(@PathVariable Long id ){
        return desenvolvedorServiceImpl.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Desenvolvedor save(@Valid @RequestBody DesenvolvedorDTO dto) {
        Desenvolvedor desenvolvedor = mapper.desenvolvedorDTOToDesenvolvedor(dto);
        return desenvolvedorServiceImpl.save(desenvolvedor);
    }

    @PutMapping("{id}")
    public Desenvolvedor update(@Valid @PathVariable Long id, @RequestBody DesenvolvedorDTO dto) {
        Desenvolvedor desenvolvedor = mapper.desenvolvedorDTOToDesenvolvedor(dto);
        return desenvolvedorServiceImpl.update(id, desenvolvedor);
    }

    @DeleteMapping ("{id}")
    public void delete(@PathVariable Long id) {
        desenvolvedorServiceImpl.delete(id);
    }


}
