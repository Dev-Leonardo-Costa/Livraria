package br.com.livraria.repository;

import br.com.livraria.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
    @Query("SELECT obj FROM Livro obj WHERE obj.categoria.id = :id_cat ORDER BY id")
    List<Livro> buscarPorCategoria(@Param(value = "id_cat") Long id_cat);

}
