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

    public void instanciaBaseDeDados() {
        Categoria categoria1 = new Categoria(null, "Informatica", "Tecnologia");
        Categoria categoria2 = new Categoria(null, "Psicologia", "Negócios");

        Livro cleanCode = new Livro(null, "Clean Code", "Robert Martins", "Um dos principais erros que os programadores cometem é acreditar que, uma vez que o código está pronto e funcionando, não precisa mais de revisão. Porém, um sistema nunca está totalmente finalizado, sempre existe a necessidade de atualizações e novas funcionalidades. Além disso, o código envelhece e pode se tornar obsoleto. É nesse cenário que o Clean Code se encaixa.A ideia por trás dos seus princípios é tornar o desenvolvimento e a manutenção cada vez mais simples. Afinal, um código sendo remendado por muito tempo torna-se impossível de manter, fazendo com que seja mais vantajoso iniciar do zero do que prosseguir em uma versão ruim.Logo, o código limpo evita gastos desnecessários com manutenção e torna o software preparado para novas atualizações e melhorias.", categoria1);

        Livro mindset = new Livro(null, "A nova psicologia do sucesso", "Carol S. Dweck", "Esse é o ponto chave da questão. Pessoas com o Mindset Fixo vivem tão bem quanto pessoas com o Mindset Crescente. Não se trata de cidadãos de primeira e segunda classe. Longe disso. Mas na hora da adversidade, na hora de lidar com problemas é que a “turma do Mindset Crescente” dá um show. E esse show é o um grande diferencial entre os grupos. Essa diferença é fundamental para o sucesso. Quando temos o Mindset Fixo e nos deparamos com grandes problemas gastamos muito tempo de forma errada. Gastamos tempo com autoafirmação enganosa, tentando provar que não estamos errado e que a culpa não é nossa. Estamos sempre buscando um culpado para nos eximir de qualquer responsabilidade negativa. E quando conseguimos repassar a culpa sentimos aquele alivio. Você já sentiu isso alguma vez? E o que isso traz de positivo pra nós? Absolutamente nada. Quando não assumimos um erro não aprendemos. Não evoluímos. E o que acontece? Voltamos a errar. Apenas gastamos o tempo que deveríamos usar para nossa evolução com desculpas esfarrapadas e acusação a terceiros. Mas quando você tem o Mindset Crescente a coisa muda de figura. Não há essa luta inútil contra o óbvio. Essa tentativa fútil de lutar contra as deficiências e ignora-las. Pelo contrário. Existe o reconhecimento e a criação de uma estratégia para esmaga-las, aniquila-las, destrui-las… ok, você já entendeu Isso acontece pois pessoas com o Mindset Crescente já saíram de sua zona de conforto e estão em busca de experiências que as tornem mais “cascudas”. Você já ouviu aquele ditado “nóis enverga mas não quebra”? É por aí. É esse capacidade de se “envergar” que gera crescimento real. É na adversidade que se forjam os grandes vencedores. E grande parte disso se deve a paixão por se aprimorar. ", categoria2);


        categoria1.getLivros().addAll(Arrays.asList(cleanCode));
        categoria2.getLivros().addAll(Arrays.asList(mindset));

        // salvando um livro e uma categoria no banco
        this.categoriaRepository.saveAll(Arrays.asList(categoria1));
        this.categoriaRepository.saveAll(Arrays.asList(categoria2));
    
        this.livroRepository.saveAll(Arrays.asList(cleanCode));
        this.livroRepository.saveAll(Arrays.asList(mindset));
    
    }
}
