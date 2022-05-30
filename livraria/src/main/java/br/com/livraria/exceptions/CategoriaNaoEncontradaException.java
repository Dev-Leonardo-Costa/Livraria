package br.com.livraria.exceptions;

import javax.persistence.PersistenceException;

public class CategoriaNaoEncontradaException extends PersistenceException {

    public CategoriaNaoEncontradaException() {
        super();
    }

    public CategoriaNaoEncontradaException(String message) {
        super(message);
    }

}
