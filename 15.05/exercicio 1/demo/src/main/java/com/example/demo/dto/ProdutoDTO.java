package com.example.demo.dto;

import java.math.BigDecimal;

public class ProdutoDTO {

    private final String nome;
    private final String descricao;
    private final BigDecimal preco;
    private final Integer quantidadeEmEstoque;
    private final String categoria;

    private ProdutoDTO(Builder builder) {
        this.nome = builder.nome;
        this.descricao = builder.descricao;
        this.preco = builder.preco;
        this.quantidadeEmEstoque = builder.quantidadeEmEstoque;
        this.categoria = builder.categoria;
    }

    public String getNome() { return nome; }
    public String getDescricao() { return descricao; }
    public BigDecimal getPreco() { return preco; }
    public Integer getQuantidadeEmEstoque() { return quantidadeEmEstoque; }
    public String getCategoria() { return categoria; }

    public static class Builder {
        private String nome;
        private String descricao;
        private BigDecimal preco;
        private Integer quantidadeEmEstoque;
        private String categoria;

        public Builder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public Builder descricao(String descricao) {
            this.descricao = descricao;
            return this;
        }

        public Builder preco(BigDecimal preco) {
            this.preco = preco;
            return this;
        }

        public Builder quantidadeEmEstoque(Integer quantidadeEmEstoque) {
            this.quantidadeEmEstoque = quantidadeEmEstoque;
            return this;
        }

        public Builder categoria(String categoria) {
            this.categoria = categoria;
            return this;
        }

        public ProdutoDTO build() {
            return new ProdutoDTO(this);
        }
    }
}
