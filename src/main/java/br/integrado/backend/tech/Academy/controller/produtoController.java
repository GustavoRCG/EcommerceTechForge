package br.integrado.backend.tech.Academy.controller;

import br.integrado.backend.tech.Academy.dto.Produto_RequestDTO;
import br.integrado.backend.tech.Academy.model.Produto;
import br.integrado.backend.tech.Academy.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    @GetMapping
    public ResponseEntity<List<Produto>> findAll() {
        List<Produto> produtos = this.repository.findAll();
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/{id}")
    public Produto findById(@PathVariable Integer id) {
        return this.repository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Produto nao foi encontrado"));
    }

    @PostMapping
    public ResponseEntity<Produto> save(@RequestBody Produto_RequestDTO dto) {
        if (dto.nome().isEmpty()) {
            return ResponseEntity.status(428).build();
        }

        Produto produto = new Produto();
        produto.setNome(dto.nome());
        this.repository.save(produto);
        return ResponseEntity.ok(produto);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {

        Optional<Produto> produtoOpt = repository.(id);
        if (produtoOpt.isEmpty()) {
            return ResponseEntity.badRequest().body("Usuario não encontrado com o id fornecido");
        }
        repository.deleteById(id);
        return ResponseEntity.ok().body("Usuario deletado com sucesso.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Produto_RequestDTO dto) {
        if (dto.nome().isEmpty()) {
            return ResponseEntity.status(428).build();
        }

        Produto produto = this.repository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Produto nao foi encontrado"));

        produto.setNome(dto.nome());

        this.repository.save(produto);
        return ResponseEntity.ok(produto);
    }

    @PostMapping
    public ResponseEntity<Produto> addDescricao(@PathVariable Integer id, @RequestBody produto_RequestDT0 dto) {

        Produto produto = this.repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Produto não encontrado"));
        produto.setDescricao(descricao);
        
        this.repository.save(null)(produto);
        return ResponseEntity.ok(produto);
    }
}
