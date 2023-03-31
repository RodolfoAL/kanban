package br.com.ada.kanban.service;

import br.com.ada.kanban.domain.Desenvolvedor;

import java.util.List;

public interface DesenvolvedorService {

    List<Desenvolvedor> list();
    Desenvolvedor save( Desenvolvedor desenvolvedor);
    Desenvolvedor findById(Long id);
    Desenvolvedor update(Long id, Desenvolvedor desenvolvedor);

    void delete(Long id);
}
