package br.com.ada.kanban.exceptions;

public class TarefaAlreadyExistsException extends RuntimeException {

    public TarefaAlreadyExistsException(){super("A Tarefa já existe");}

}
