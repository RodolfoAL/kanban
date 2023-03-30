package br.com.ada.kanban.sevice;

import br.com.ada.kanban.domain.Desenvolvedor;
import br.com.ada.kanban.dto.DesenvolvedorDTO;

import java.util.List;

public interface IDesenvolvedorService {

    List<Desenvolvedor> list();
    Desenvolvedor save( Desenvolvedor desenvolvedor);
    Desenvolvedor findById(Long id);
    Desenvolvedor update(Long id, Desenvolvedor desenvolvedor);

    void delete(Long id);
}
