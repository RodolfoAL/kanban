package br.com.ada.kanban.dto;

import br.com.ada.kanban.domain.Cliente;
import br.com.ada.kanban.domain.Desenvolvedor;
import br.com.ada.kanban.domain.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TarefaDTO {

    @NotBlank(message = "Este é um campo obrigatório, não deve ser nulo ou em branco")
    private String titulo;

    @NotBlank(message = "Este é um campo obrigatório, não deve ser nulo ou em branco")
    private String descricao;

//   @NotNull(message = "Este é um campo obrigatório, não deve ser nulo ou em branco")
    private Cliente cliente;

}
