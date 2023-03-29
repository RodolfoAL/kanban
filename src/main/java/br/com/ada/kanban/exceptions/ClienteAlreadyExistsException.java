package br.com.ada.kanban.exceptions;

public class ClienteAlreadyExistsException extends RuntimeException{

    public ClienteAlreadyExistsException() {
        super("O Cliente já existe");
    }
}
