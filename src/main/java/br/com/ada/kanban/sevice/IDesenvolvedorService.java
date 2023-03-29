package br.com.ada.kanban.sevice;

import br.com.ada.kanban.domain.Desenvolvedor;
import br.com.ada.kanban.dto.DesenvolvedorDTO;

import java.util.List;

public interface IDesenvolvedorService {

    List<Desenvolvedor> list();
    Desenvolvedor save(@Valid DesenvolvedorDTO desenvolvedor);
    Desenvolvedor findById(Long id);
    Desenvolvedor update(Long id, DesenvolvedorDTO desenvolvedor);

    void delete(Long id);
}
