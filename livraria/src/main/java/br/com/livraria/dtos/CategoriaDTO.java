package br.com.livraria.dtos;

import br.com.livraria.model.Categoria;
import lombok.Data;

import java.io.Serializable;

@Data
public class CategoriaDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String nome;
    private String descricao;

    public CategoriaDTO(){
        super();
    }

    public CategoriaDTO(Categoria objCategoria) {
        this.id = objCategoria.getId();
        this.nome = objCategoria.getNome();
        this.descricao = objCategoria.getDescricao();
    }

}
