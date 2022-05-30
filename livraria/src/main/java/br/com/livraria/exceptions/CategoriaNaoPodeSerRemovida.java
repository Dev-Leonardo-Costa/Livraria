package br.com.livraria.exceptions;

import javax.persistence.PersistenceException;

public class CategoriaNaoPodeSerRemovida extends PersistenceException {

    public CategoriaNaoPodeSerRemovida() {
        super();
    }

    public CategoriaNaoPodeSerRemovida(String message) {
        super(message);
    }
}
