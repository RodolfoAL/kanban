package br.com.ada.kanban.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@Builder
@Entity
public class Desenvolvedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    @ManyToMany
    @JoinTable(name = "desenvolvedor_tarefa",
    joinColumns = @JoinColumn(name = "desenvolvedor_id"),
    inverseJoinColumns = @JoinColumn(name = "tarefa_id"))
    private Set<Tarefa> tarefa = new HashSet<Tarefa>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Desenvolvedor that = (Desenvolvedor) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
