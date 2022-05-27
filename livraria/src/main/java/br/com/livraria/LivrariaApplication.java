package br.com.livraria;

import br.com.livraria.model.Categoria;
import br.com.livraria.model.Livro;
import br.com.livraria.repository.CategoriaRepository;
import br.com.livraria.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
public class LivrariaApplication implements CommandLineRunner {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private LivroRepository livroRepository;

    public static void main(String[] args) {
        SpringApplication.run(LivrariaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Categoria categoria1 = new Categoria();
        categoria1.setNome("Informatica");
        categoria1.setDescricao("Livro de Ti");

        Livro livro1 = new Livro();
        livro1.setTitulo("Clean code");
        livro1.setNome_autor("Robert Martins");
        livro1.setTexto("Lorim ipson.....");
        livro1.setCategoria(categoria1);

        categoria1.getLivros().addAll(Arrays.asList(livro1));

        // salvando um livro e uma categoria no banco
        this.categoriaRepository.saveAll(Arrays.asList(categoria1));
        this.livroRepository.saveAll(Arrays.asList(livro1));
    }
}
