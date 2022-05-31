package br.com.livraria.dtos;

import br.com.livraria.model.Categoria;
import br.com.livraria.model.Livro;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
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
