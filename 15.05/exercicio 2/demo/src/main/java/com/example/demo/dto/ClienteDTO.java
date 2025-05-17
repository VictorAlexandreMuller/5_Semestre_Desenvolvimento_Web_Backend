package com.example.demo.dto;

import java.time.LocalDate;

public class ClienteDTO {

    private final String nome;
    private final String email;
    private final String cpf;
    private final LocalDate dataNascimento;
    private final String telefone;

    private ClienteDTO(Builder builder) {
        this.nome = builder.nome;
        this.email = builder.email;
        this.cpf = builder.cpf;
        this.dataNascimento = builder.dataNascimento;
        this.telefone = builder.telefone;
    }

    public String getNome() { return nome; }
    public String getEmail() { return email; }
    public String getCpf() { return cpf; }
    public LocalDate getDataNascimento() { return dataNascimento; }
    public String getTelefone() { return telefone; }

    public static class Builder {
        private String nome;
        private String email;
        private String cpf;
        private LocalDate dataNascimento;
        private String telefone;

        public Builder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder cpf(String cpf) {
            this.cpf = cpf;
            return this;
        }

        public Builder dataNascimento(LocalDate dataNascimento) {
            this.dataNascimento = dataNascimento;
            return this;
        }

        public Builder telefone(String telefone) {
            this.telefone = telefone;
            return this;
        }

        public ClienteDTO build() {
            return new ClienteDTO(this);
        }
    }
}
