package br.com.livraria.service;

import br.com.livraria.model.Categoria;
import br.com.livraria.model.Livro;
import br.com.livraria.repository.CategoriaRepository;
import br.com.livraria.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private LivroRepository livroRepository;

    public void instanciaBaseDeDado() {
        Categoria categoria1 = new Categoria(null, "Informatica", "Livro de Ti");
        Categoria categoria2 = new Categoria(null, "Psicologia", "Saúde");
        Categoria categoria3 = new Categoria(null, "Pessoal", "Habito melhores");
        Categoria categoria4 = new Categoria(null, "Informatica", "Programação");

        Livro cleanCode = new Livro(null, "Seja um programado melhor", "Robert Martins", "", categoria1);
        Livro mindset = new Livro(null, "A nova psicologia do sucesso", "Carol S. Dweck", "a atitude mental com que encaramos a vida", categoria2);
        Livro habito = new Livro(null, "O poder do hábito", "Charles Duhigg", " mostra que a chave para o sucesso é entender como os hábitos", categoria3);
        Livro java = new Livro(null, " Ensino didático: Desenvolvimento e implementação de aplicações", "Saraiva S.C", "Java tem se desenvolvido muito nos últimos anos, fato que a tem colocado entre as linguagens de programação mais usadas.", categoria4);

        categoria1.getLivros().addAll(Arrays.asList(cleanCode));
        categoria2.getLivros().addAll(Arrays.asList(mindset));
        categoria3.getLivros().addAll(Arrays.asList(habito));
        categoria4.getLivros().addAll(Arrays.asList(java));

        // salvando um livro e uma categoria no banco
        this.categoriaRepository.saveAll(Arrays.asList(categoria1));
        this.categoriaRepository.saveAll(Arrays.asList(categoria2));
        this.categoriaRepository.saveAll(Arrays.asList(categoria3));
        this.categoriaRepository.saveAll(Arrays.asList(categoria4));
        this.livroRepository.saveAll(Arrays.asList(cleanCode));
        this.livroRepository.saveAll(Arrays.asList(mindset));
        this.livroRepository.saveAll(Arrays.asList(habito));
        this.livroRepository.saveAll(Arrays.asList(java));
    }
}
