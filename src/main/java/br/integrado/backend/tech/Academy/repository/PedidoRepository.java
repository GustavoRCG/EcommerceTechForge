package br.integrado.backend.tech.Academy.repository;

import br.integrado.backend.tech.Academy.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
}
