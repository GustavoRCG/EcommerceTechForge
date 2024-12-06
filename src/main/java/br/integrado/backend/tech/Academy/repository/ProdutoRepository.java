package br.integrado.backend.tech.Academy.repository;

import br.integrado.backend.tech.Academy.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
