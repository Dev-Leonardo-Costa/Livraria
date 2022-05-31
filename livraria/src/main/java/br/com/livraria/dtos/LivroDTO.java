package br.com.livraria.dtos;

import br.com.livraria.model.Livro;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class LivroDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String titulo;

    public LivroDTO() {
        super();
    }

    public LivroDTO(Livro objLivro) {
        super();
        this.id = objLivro.getId();
        this.titulo = objLivro.getTitulo();
    }
}
