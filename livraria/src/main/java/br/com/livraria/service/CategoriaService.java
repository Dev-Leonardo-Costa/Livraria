package br.com.livraria.service;

import br.com.livraria.exceptions.CategoriaNaoEncontradaException;
import br.com.livraria.model.Categoria;
import br.com.livraria.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria buscarPorId(Long id) {
        Optional<Categoria> obj = categoriaRepository.findById(id);
        return obj.orElseThrow(() -> new CategoriaNaoEncontradaException("Categoria não encontrada"));
    }
    public List<Categoria> buscarTodas() {
        return categoriaRepository.findAll();
    }
}
