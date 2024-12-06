package br.integrado.backend.tech.Academy.repository;

import br.integrado.backend.tech.Academy.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
