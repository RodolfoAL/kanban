package br.com.ada.kanban.config;

import br.com.ada.kanban.dto.ErrorDTO;
import br.com.ada.kanban.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class HandlerException {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;

    }
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ClienteNotFoundException.class)
    public ErrorDTO handlerClienteNotFound(ClienteNotFoundException e) {
        return ErrorDTO.builder()
                .message(e.getMessage())
                .build();
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(ClienteAlreadyExistsException.class)
    public ErrorDTO handlerClienteAlreadyExistsException(ClienteAlreadyExistsException e) {
        return ErrorDTO.builder()
                .message(e.getMessage())
                .build();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(DesenvolvedorNotFoundException.class)
    public ErrorDTO handlerDesenvolvedorNotFoundException(DesenvolvedorNotFoundException e) {
        return ErrorDTO.builder()
                .message(e.getMessage())
                .build();
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(DesenvolvedorAlreadyExistException.class)
    public ErrorDTO handlerDesenvolvedorAlreadyExistsException(DesenvolvedorAlreadyExistException e) {
        return ErrorDTO.builder()
                .message(e.getMessage())
                .build();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(TarefaNotFoundException.class)
    public ErrorDTO handlerTarefaNotFoundException(TarefaNotFoundException e) {
        return ErrorDTO.builder()
                .message(e.getMessage())
                .build();
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(TarefaAlreadyExistsException.class)
    public ErrorDTO handlerTarefaAlreadyExistsException(TarefaAlreadyExistsException e) {
        return ErrorDTO.builder()
                .message(e.getMessage())
                .build();
    }
}
