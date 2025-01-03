package br.integrado.backend.tech.Academy.controller;

import br.integrado.backend.tech.Academy.dto.ProdutoRequestDTO;
import br.integrado.backend.tech.Academy.dto.TipoPratoRequestDTO;
import br.integrado.backend.tech.Academy.model.Produto;
import br.integrado.backend.tech.Academy.model.TipoPrato;
import br.integrado.backend.tech.Academy.repository.TipoPratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/TipoPrato")
public class TipoPratoController {

    @Autowired
    private TipoPratoRepository repository;

    @GetMapping
    public ResponseEntity<List<TipoPrato>> findAll() {
        List<TipoPrato> produtos = this.repository.findAll();
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/{id}")
    public TipoPrato findById(@PathVariable Integer id) {
        return this.repository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Tipo de prato não foi encontrado"));
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody ProdutoRequestDTO dto) {

        TipoPrato tipoPrato = new TipoPrato();
        tipoPrato.setId(dto.getId());
        tipoPrato.setNome(dto.getNome());

        TipoPrato produtoSave = repository.save(tipoPrato);
        return ResponseEntity.ok(produtoSave);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody ProdutoRequestDTO dto) {


        TipoPrato tipoPrato = new TipoPrato();
        tipoPrato.setId(dto.getId());
        tipoPrato.setNome(dto.getNome());

        TipoPrato saveEndereco = repository.save(tipoPrato);
        return ResponseEntity.ok(saveEndereco);

    }



    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        Optional<TipoPrato> enderecoOpt  = repository.findById(id);
        if (enderecoOpt.isEmpty()) {
            return ResponseEntity.badRequest().body("Endereço não encontrado com o id Fornecido");
        }
        repository.deleteById(id);
        return ResponseEntity.badRequest().body("Endereco deletado com Sucesso!");
    }

}
