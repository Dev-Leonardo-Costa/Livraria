package br.com.livraria.exceptions;

import javax.persistence.PersistenceException;

public class CategoriaNaoPodeSerRemovidaException extends PersistenceException {

    public CategoriaNaoPodeSerRemovidaException() {
        super();
    }

    public CategoriaNaoPodeSerRemovidaException(String message) {
        super(message);
    }
}
