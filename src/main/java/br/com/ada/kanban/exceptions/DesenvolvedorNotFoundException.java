package br.com.ada.kanban.exceptions;

public class DesenvolvedorNotFoundException extends RuntimeException {
    public DesenvolvedorNotFoundException(){
        super("Desenvolvedor não encontrado");
    }
}
