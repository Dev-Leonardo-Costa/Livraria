package br.com.livraria.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode
public class Categoria {

    @Id
    private Integer id;
    private String nome;
    private String descricao;

    private List<Livro> livros = new ArrayList<>();
}
