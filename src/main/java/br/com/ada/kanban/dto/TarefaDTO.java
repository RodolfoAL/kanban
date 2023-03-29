package br.com.ada.kanban.dto;

import br.com.ada.carloca.domain.Cliente;
import br.com.ada.carloca.domain.Desenvolvedor;
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
public class TarefaDTO {

    @NotBlank(message = "Este é um campo obrigatório, não deve ser nulo ou em branco")
    private String titulo;
    @NotBlank(message = "Este é um campo obrigatório, não deve ser nulo ou em branco")
    private String descricao;
    @NotBlank(message = "Este é um campo obrigatório, não deve ser nulo ou em branco")
    private List<Desenvolvedor> desenvolvedor;
    @NotBlank(message = "Este é um campo obrigatório, não deve ser nulo ou em branco")
    private Cliente cliente;
}
