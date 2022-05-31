package br.com.livraria.exceptions;

import javax.persistence.PersistenceException;

public class LivroNaoEncontradoException extends PersistenceException {

    public LivroNaoEncontradoException() {
        super();
    }
    public LivroNaoEncontradoException(String message) {
        super(message);
    }
}
