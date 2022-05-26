package br.com.livraria.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Id;

@Data
@EqualsAndHashCode
public class Livro {

    @Id
    private Integer id;
    private String titulo;
    private String nome_autor;
    private String texto;
}