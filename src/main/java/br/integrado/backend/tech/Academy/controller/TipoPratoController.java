package br.integrado.backend.tech.Academy.controller;

import br.integrado.backend.tech.Academy.dto.TipoPratoRequestDTO;
import br.integrado.backend.tech.Academy.model.TipoPrato;
import br.integrado.backend.tech.Academy.repository.TipoPratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<TipoPrato> save(@RequestBody TipoPratoRequestDTO dto) {
        if (dto.nome().isEmpty()) {
            return ResponseEntity.status(428).build();
        }

        TipoPrato tipoPrato = new TipoPrato();
        tipoPrato.setNome(dto.nome());
        this.repository.save(tipoPrato);
        return ResponseEntity.ok(tipoPrato);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        TipoPrato tipoPrato = this.repository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Tipo de prato não foi encontrado"));

        this.repository.delete(tipoPrato);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoPrato> update(@PathVariable Integer id, @RequestBody TipoPratoRequestDTO dto) {
        if (dto.nome().isEmpty()) {
            return ResponseEntity.status(428).build();
        }

        TipoPrato tipoPrato = this.repository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Tipo de prato não foi encontrado"));

        tipoPrato.setNome(dto.nome());

        this.repository.save(tipoPrato);
        return ResponseEntity.ok(tipoPrato);
    }
}
