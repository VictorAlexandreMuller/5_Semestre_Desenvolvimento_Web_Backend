package com.example.demo.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true)
    private String cpf;

    private String celular;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Animal> animais = new ArrayList<>();

    public Cliente() {
    }

    public Cliente(Long id, String nome, String cpf, String celular, List<Animal> animais) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.celular = celular;
        this.animais = animais;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public List<Animal> getAnimais() {
        return animais;
    }

    public void setAnimais(List<Animal> animais) {
        this.animais = animais;
    }

    @Override
    public String toString() {
        return "Cliente [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", celular=" + celular + ", animais=" + animais
                + "]";
    }

    

}
