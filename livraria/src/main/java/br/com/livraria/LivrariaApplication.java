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
public class LivrariaApplication {

    public static void main(String[] args) {
        SpringApplication.run(LivrariaApplication.class, args);
    }

}
