package br.integrado.backend.tech.Academy.controller;

import br.integrado.backend.tech.Academy.dto.ProdutoRequestDTO;
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
    private ProdutoRepository produtoRepository;

    @GetMapping
    public ResponseEntity<List<Produto>> findAll() {
        List<Produto> produto = this.produtoRepository.findAll();
        return ResponseEntity.ok(produto);
    }

    @GetMapping("/{id}")
    public Produto findById(@PathVariable Integer id) {
        return this.produtoRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Tipo de prato não foi encontrado"));
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody ProdutoRequestDTO dto) {

        Produto produto = new Produto();
        produto.setNome(dto.getNome());
        produto.setDescricao(dto.getDescricao());

        Produto produtoSave = produtoRepository.save(produto);
        return ResponseEntity.ok(produto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody ProdutoRequestDTO dto) {


        Produto produto = new Produto();
        produto.setNome(dto.getNome());
        produto.setDescricao(dto.getDescricao());

        Produto saveEndereco = produtoRepository.save(produto);
        return ResponseEntity.ok(saveEndereco);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        Optional<Produto>  enderecoOpt  = produtoRepository.findById(id);
        if (enderecoOpt.isEmpty()) {
            return ResponseEntity.badRequest().body("Endereço não encontrado com o id Fornecido");
        }
        produtoRepository.deleteById(id);
        return ResponseEntity.badRequest().body("Endereco deletado com Sucesso!");
    }

}
