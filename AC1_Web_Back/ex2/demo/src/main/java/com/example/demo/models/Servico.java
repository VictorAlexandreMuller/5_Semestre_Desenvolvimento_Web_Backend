package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;
    private String tipo;
    private Double preco;
    private Integer tempoDuracao;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "animal_id")
    private Animal animal;

    public Servico() {
    }

    public Servico(Long id, String descricao, String tipo, Double preco, Integer tempoDuracao, Cliente cliente,
            Animal animal) {
        this.id = id;
        this.descricao = descricao;
        this.tipo = tipo;
        this.preco = preco;
        this.tempoDuracao = tempoDuracao;
        this.cliente = cliente;
        this.animal = animal;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getTempoDuracao() {
        return tempoDuracao;
    }

    public void setTempoDuracao(Integer tempoDuracao) {
        this.tempoDuracao = tempoDuracao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    @Override
    public String toString() {
        return "Servico [id=" + id + ", descricao=" + descricao + ", tipo=" + tipo + ", preco=" + preco
                + ", tempoDuracao=" + tempoDuracao + ", cliente=" + cliente + ", animal=" + animal + "]";
    }

    
}
