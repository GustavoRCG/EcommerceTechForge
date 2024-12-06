package br.integrado.backend.tech.Academy.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "pedido")
public class Pedido {

    @EmbeddedId
    private PedidoPK id;

    @ManyToOne
    @MapsId("produtoId")
    @JoinColumn(name = "id_produto", referencedColumnName = "id")
    @JsonIgnoreProperties("produtos")
    @JsonBackReference
    private Produto produto;

    @ManyToOne
    @MapsId("clienteId")
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    @JsonIgnoreProperties("cliente")
    private Cliente cliente;



    public PedidoPK getId() {
        return id;
    }

    public void setId(PedidoPK id) {
        this.id = id;
    }


    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return Objects.equals(id, pedido.id) && Objects.equals(produto, pedido.produto) && Objects.equals(cliente, pedido.cliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, produto, cliente);
    }
}
