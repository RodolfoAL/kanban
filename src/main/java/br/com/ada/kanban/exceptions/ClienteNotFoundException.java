package br.com.ada.kanban.exceptions;

public class ClienteNotFoundException extends RuntimeException{

    public ClienteNotFoundException() {
        super("Cliente não encontrado");
    }
}
