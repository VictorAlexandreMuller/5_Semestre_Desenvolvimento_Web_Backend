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
    private Double preco;
    private String setor;
    private LocalDate validade;
    
    public Produto(Long id, String descricao, Double preco, String setor, LocalDate validade) {
        this.id = id;
        this.descricao = descricao;
        this.preco = preco;
        this.setor = setor;
        this.validade = validade;
    }

    public Produto() {
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
    public Double getPreco() {
        return preco;
    }
    public void setPreco(Double preco) {
        this.preco = preco;
    }
    public String getSetor() {
        return setor;
    }
    public void setSetor(String setor) {
        this.setor = setor;
    }
    public LocalDate getValidade() {
        return validade;
    }
    public void setValidade(LocalDate validade) {
        this.validade = validade;
    }

    @Override
    public String toString() {
        return "Produto [id=" + id + ", descricao=" + descricao + ", preco=" + preco + ", setor=" + setor
                + ", validade=" + validade + "]";
    }

    

}
