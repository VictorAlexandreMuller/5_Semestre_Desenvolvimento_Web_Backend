package com.example.demo.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "nome")
public class Medicamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String laboratorio;

    @Column(nullable = false)
    private BigDecimal preco;

    @Column(nullable = false)
    private LocalDate dataValidade;

    public Medicamento() {
    }

    public Medicamento(Long id, String nome, String laboratorio, BigDecimal preco, LocalDate dataValidade) {
        this.id = id;
        this.nome = nome;
        this.laboratorio = laboratorio;
        this.preco = preco;
        this.dataValidade = dataValidade;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }

    @Override
	public String toString() {
		return "[ID: " + id + " ] " + "Medicamento ==> [Nome: " + nome + ", Laboratório: " + laboratorio + ", Preço: " + preco
				+ ", Data de Validade: " + dataValidade + "]";
	}

}
