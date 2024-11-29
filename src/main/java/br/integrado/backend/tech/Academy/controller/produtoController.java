package br.integrado.backend.tech.Academy.controller;

import br.integrado.backend.tech.Academy.dto.produtoRequestDTO;
import br.integrado.backend.tech.Academy.model.produto;
import br.integrado.backend.tech.Academy.repository.produtoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produto")
public class produtoController {

    @Autowired
    private produtoRepository repository;

    @GetMapping
    public ResponseEntity<List<produto>> findAll() {
        List<produto> produtos = this.repository.findAll();
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/{id}")
    public produto findById(@PathVariable Integer id) {
        return this.repository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Produto nao foi encontrado"));
    }

    @PostMapping
    public ResponseEntity<produto> save(@RequestBody produtoRequestDTO dto) {
        if (dto.nome().isEmpty()) {
            return ResponseEntity.status(428).build();
        }

        produto produto = new produto();
        produto.setNome(dto.nome());
        this.repository.save(produto);
        return ResponseEntity.ok(produto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        produto produto = this.repository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Produto nao foi encontrado"));

        this.repository.delete(produto);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<produto> update(@PathVariable Integer id, @RequestBody produtoRequestDTO dto) {
        if (dto.nome().isEmpty()) {
            return ResponseEntity.status(428).build();
        }

        produto produto = this.repository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Produto nao foi encontrado"));

        produto.setNome(dto.nome());

        this.repository.save(produto);
        return ResponseEntity.ok(produto);
    }
}
