package br.com.ada.kanban.exceptions;

public class DesenvolvedorAlreadyExistException extends RuntimeException {

    public DesenvolvedorAlreadyExistException() {
        super("O Desenvolvedor já existe");
    }

}
