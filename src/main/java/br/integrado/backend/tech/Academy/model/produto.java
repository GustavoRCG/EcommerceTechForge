package br.integrado.backend.tech.Academy.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "produtos")
public class produto {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        @Column(name = "name")
        private String nome;

        @ManyToOne
        @JoinColumn(name = "tipoprato_id", referencedColumnName = "id")
        private TipoPrato tipoPrato;

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

        public TipoPrato getTipoPrato() {
                return tipoPrato;
        }

        public void setTipoPrato(TipoPrato tipoPrato) {
                this.tipoPrato = tipoPrato;
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                produto produto = (br.integrado.backend.tech.Academy.model.produto) o;
                return Objects.equals(id, produto.id);
        }

        @Override
        public int hashCode() {
                return Objects.hashCode(id);
        }
}
