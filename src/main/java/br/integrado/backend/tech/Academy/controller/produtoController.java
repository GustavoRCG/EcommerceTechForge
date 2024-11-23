package br.integrado.backend.tech.Academy.controller;

import br.integrado.backend.tech.Academy.model.produto;
import br.integrado.backend.tech.Academy.repository.produtoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/produto")
public class produtoController {

    @Autowired
    private produtoRepository repository;

    @GetMapping
    public List<produto> findAll() {
        return this.repository.findAll();
    }

    @GetMapping("/{id}")
    public produto findById(@PathVariable Integer id) {
        return this.repository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Produto nao foi encontrado"));
    }

}
