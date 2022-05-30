package br.com.livraria.exceptions;

import br.com.livraria.model.Categoria;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(CategoriaNaoEncontradaException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ResponseEntity<StandardError> categoriaNaoEncontrada(CategoriaNaoEncontradaException e, HttpServletRequest request) {
        String error = "Categoria não encontrada.";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(),
                request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}
