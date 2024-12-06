package br.integrado.backend.tech.Academy.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.Objects;

public class PedidoPK {

    @Column(name = "id_produto")
    private Integer produtoId;

    @Column(name = "id_cliente")
    private Integer clienteId;

    public Integer getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Integer produtoId) {
        this.produtoId = produtoId;
    }

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PedidoPK pedidoPK = (PedidoPK) o;
        return Objects.equals(produtoId, pedidoPK.produtoId) && Objects.equals(clienteId, pedidoPK.clienteId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(produtoId, clienteId);
    }
}
