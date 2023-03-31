package br.com.ada.kanban.exceptions;

public class TarefaNotFoundException extends RuntimeException {

    public TarefaNotFoundException(){super("Tarefa não encontrada");}

}
