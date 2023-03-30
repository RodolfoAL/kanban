package br.com.ada.kanban.controller;

import br.com.ada.kanban.domain.Cliente;
import br.com.ada.kanban.domain.Desenvolvedor;
import br.com.ada.kanban.dto.ClienteDTO;
import br.com.ada.kanban.dto.DesenvolvedorDTO;
import br.com.ada.kanban.sevice.DesenvolvedorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        return desenvolvedorService.save(dto);
    }

    @PutMapping("{id}")
    public Desenvolvedor update(@Valid @PathVariable Long id, @RequestBody DesenvolvedorDTO dto) {
        return desenvolvedorService.update(id, dto);
    }

    @DeleteMapping ("{id}")
    public void delete(@PathVariable Long id) {
        desenvolvedorService.delete(id);
    }


}
