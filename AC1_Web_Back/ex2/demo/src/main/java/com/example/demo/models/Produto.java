package com.example.demo.models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;
    private String categoria;
    private LocalDate validade;
    private Double preco;
    public Produto() {
    }
    public Produto(Long id, String descricao, String categoria, LocalDate validade, Double preco) {
        this.id = id;
        this.descricao = descricao;
        this.categoria = categoria;
        this.validade = validade;
        this.preco = preco;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public LocalDate getValidade() {
        return validade;
    }
    public void setValidade(LocalDate validade) {
        this.validade = validade;
    }
    public Double getPreco() {
        return preco;
    }
    public void setPreco(Double preco) {
        this.preco = preco;
    }
    @Override
    public String toString() {
        return "Produto [id=" + id + ", descricao=" + descricao + ", categoria=" + categoria + ", validade=" + validade
                + ", preco=" + preco + "]";
    }

    
}
