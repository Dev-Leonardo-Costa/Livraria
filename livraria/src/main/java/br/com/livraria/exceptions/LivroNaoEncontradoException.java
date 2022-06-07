package br.com.livraria.exceptions;

public class LivroNaoEncontradoException extends RuntimeException {

    public LivroNaoEncontradoException() {
        super();
    }

    public LivroNaoEncontradoException(String message) {
        super(message);
    }
}
