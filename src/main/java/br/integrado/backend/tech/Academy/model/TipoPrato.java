package br.integrado.backend.tech.Academy.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tipoprato")
public class TipoPrato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", length = 200)
    private String nome;

    @OneToMany(mappedBy = "tipoPrato")
    @JsonIgnoreProperties("tipoPrato")
    private List<produto> produtos;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<produto> produtos) {
        this.produtos = produtos;
    }
}
