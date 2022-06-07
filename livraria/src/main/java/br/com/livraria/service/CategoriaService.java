package br.com.livraria.service;

import br.com.livraria.dtos.CategoriaDTO;

import br.com.livraria.exceptions.CategoriaNaoEncontradaException;
import br.com.livraria.exceptions.CategoriaNaoPodeSerRemovidaException;
import br.com.livraria.model.Categoria;
import br.com.livraria.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    private static final String CATEGORIA_NAO_ENCONTRADA = "Categoria não encontrada";
    private static final String CATEGORIA_NAO_PODE_SER_REMOVIDA = "Categoria não pode ser removida! Possui livros associados";

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria buscarPorId(Long id) {
        Optional<Categoria> obj = categoriaRepository.findById(id);
        return obj.orElseThrow(
                () -> new CategoriaNaoEncontradaException(CATEGORIA_NAO_ENCONTRADA));
    }

    public List<Categoria> buscarTodas() {
        return categoriaRepository.findAll();
    }

    public Categoria salvar(Categoria categoria) {
        categoria.setId(null);
        return categoriaRepository.saveAndFlush(categoria);
    }

    public Categoria atualizar(Long id, CategoriaDTO categoriaDTO) {
        Categoria categoriaObj = buscarPorId(id);
        categoriaObj.setNome(categoriaDTO.getNome());
        categoriaObj.setDescricao(categoriaDTO.getDescricao());
        return categoriaRepository.saveAndFlush(categoriaObj);
    }

    public void remover(Long id) {
        buscarPorId(id);
        try {
            categoriaRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new CategoriaNaoPodeSerRemovidaException(CATEGORIA_NAO_PODE_SER_REMOVIDA);
        }
    }
}
