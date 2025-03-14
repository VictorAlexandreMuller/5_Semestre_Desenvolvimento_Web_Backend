package com.example.demo.models;

public class Pet {

    private int id;
    private String nome;
    private String raca;
    private String cor;
    private Double peso;
    private String tamanho;

    public Pet() {
    }
    
    public Pet(int id, String nome, String raca, String cor, Double peso, String tamanho) {
        this.id = id;
        this.nome = nome;
        this.raca = raca;
        this.cor = cor;
        this.peso = peso;
        this.tamanho = tamanho;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    

}
