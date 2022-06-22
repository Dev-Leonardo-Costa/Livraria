package br.com.livraria.controller;

import br.com.livraria.dtos.LivroDTO;
import br.com.livraria.model.Livro;
import br.com.livraria.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;
    @GetMapping("/{id}")
    public ResponseEntity<Livro> buscarPorId(@PathVariable Long id) {
        Livro obj = livroService.buscarPorId(id);
        return ResponseEntity.ok().body(obj);
    }
    @GetMapping
    public ResponseEntity<List<LivroDTO>> buscarTodos(@RequestParam(value = "categoria", defaultValue = "0") Long id_cat) {
        List<Livro> lista = livroService.buscarTodos(id_cat);
        List<LivroDTO> listaDTO = lista.stream().map(obj -> new LivroDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listaDTO);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<Livro> atulizar(@PathVariable Long id, @Valid @RequestBody Livro obj) {
        Livro novoLivro = livroService.atualizar(id, obj);
        return ResponseEntity.ok().body(novoLivro);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Livro> atulizarComPatch(@PathVariable Long id, @Valid @RequestBody Livro obj) {
        Livro novoLivro = livroService.atualizar(id, obj);
        return ResponseEntity.ok().body(novoLivro);
    }
    @PostMapping
    public ResponseEntity<Livro> salvar(@RequestParam(value = "categoria", defaultValue = "0") Long id_cat, @Valid @RequestBody Livro obj) {
        Livro novoLivro = livroService.salvar(id_cat, obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/livros/{id}")
                .buildAndExpand(novoLivro.getId())
                .toUri();
        return ResponseEntity.created(uri).body(novoLivro);
    }
}
