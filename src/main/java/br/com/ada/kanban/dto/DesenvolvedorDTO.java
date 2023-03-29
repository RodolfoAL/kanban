package br.com.ada.kanban.dto;

import br.com.ada.kanban.domain.Tarefa;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class DesenvolvedorDTO {

    @NotBlank (message = "Este é um campo obrigatório, não deve ser nulo ou em branco")
    private String nome;
    @NotBlank (message = "Este é um campo obrigatório, não deve ser nulo ou em branco")
    private List<Tarefa> tarefa;
}
