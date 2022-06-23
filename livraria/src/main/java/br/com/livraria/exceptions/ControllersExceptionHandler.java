package br.com.livraria.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

import static java.lang.String.*;

@ControllerAdvice
public class ControllersExceptionHandler {

    @ExceptionHandler(CategoriaNaoEncontradaException.class)
    public ResponseEntity<StandardError> categoriaNaoEncontada(CategoriaNaoEncontradaException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(Instant.now(), valueOf(status.value()), e.getMessage());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(LivroNaoEncontradoException.class)
    public ResponseEntity<StandardError> livroNaoEncontrada(LivroNaoEncontradoException e, ServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError error = new StandardError(Instant.now(), valueOf(status.value()), e.getMessage());
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(CategoriaNaoPodeSerRemovidaException.class)
    public ResponseEntity<StandardError> dataIntegrityViolationException(CategoriaNaoPodeSerRemovidaException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError error = new StandardError(Instant.now(), valueOf(status.value()), e.getMessage());
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> validationErro(MethodArgumentNotValidException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ValidationErro erros = new ValidationErro(Instant.now(), valueOf(status.value()), "Erro na validação dos campos");

        for (FieldError x : e.getBindingResult().getFieldErrors()) {
            erros.adicionarErros(x.getField(), x.getDefaultMessage());
        }
        return ResponseEntity.status(status).body(erros);
    }
}
