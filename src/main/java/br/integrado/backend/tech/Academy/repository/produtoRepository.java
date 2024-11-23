package br.integrado.backend.tech.Academy.repository;

import br.integrado.backend.tech.Academy.model.produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface produtoRepository extends JpaRepository<produto, Integer> {
}
