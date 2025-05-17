package com.example.demo.validation;

import jakarta.validation.*;
import java.util.Set;

import com.example.demo.model.Produto;

import java.util.Locale;

public class ValidadorProduto {

    public static void main(String[] args) {
        Locale.setDefault(Locale.forLanguageTag("pt-BR"));

        Produto produto = new Produto();

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<Produto>> violacoes = validator.validate(produto);

        if (!violacoes.isEmpty()) {
            System.out.println("Erros de validação encontrados:");
            for (ConstraintViolation<Produto> violacao : violacoes) {
                System.out.println("- " + violacao.getMessage());
            }
        } else {
            System.out.println("Produto válido!");
        }
    }
}
