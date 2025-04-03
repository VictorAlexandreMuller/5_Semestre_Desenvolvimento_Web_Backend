package com.example.demo.models;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long clienteId; // Alternativamente, pode usar @ManyToOne
    private Long produtoId;

    private String descricaoProduto;
    private Integer quantidade;
    private Double precoProduto;
    private Double valorTotal;

    private LocalDateTime dataVenda;

    public Venda() {
    }

    public Venda(Long id, Long clienteId, Long produtoId, String descricaoProduto, Integer quantidade,
            Double precoProduto, Double valorTotal, LocalDateTime dataVenda) {
        this.id = id;
        this.clienteId = clienteId;
        this.produtoId = produtoId;
        this.descricaoProduto = descricaoProduto;
        this.quantidade = quantidade;
        this.precoProduto = precoProduto;
        this.valorTotal = valorTotal;
        this.dataVenda = dataVenda;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public Long getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Long produtoId) {
        this.produtoId = produtoId;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(Double precoProduto) {
        this.precoProduto = precoProduto;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public LocalDateTime getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDateTime dataVenda) {
        this.dataVenda = dataVenda;
    }

    @Override
    public String toString() {
        return "Venda [id=" + id + ", clienteId=" + clienteId + ", produtoId=" + produtoId + ", descricaoProduto="
                + descricaoProduto + ", quantidade=" + quantidade + ", precoProduto=" + precoProduto + ", valorTotal="
                + valorTotal + ", dataVenda=" + dataVenda + "]";
    }

}
