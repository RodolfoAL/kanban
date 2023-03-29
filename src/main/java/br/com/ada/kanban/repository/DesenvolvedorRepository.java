package br.com.ada.kanban.repository;

import br.com.ada.kanban.domain.Desenvolvedor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DesenvolvedorRepository extends CrudRepository<Desenvolvedor, Long> {

}
