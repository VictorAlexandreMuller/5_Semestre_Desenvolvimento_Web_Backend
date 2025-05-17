package com.example.demo.validation;

import com.example.demo.model.Cliente;
import jakarta.validation.*;
import java.time.LocalDate;
import java.util.Set;

public class ValidadorCliente {

    public static void main(String[] args) {
        Cliente cliente = new Cliente(); // inválido: tudo null

        // Exemplo com erro proposital
        cliente.setCpf("123"); // CPF com menos dígitos
        cliente.setEmail("email-invalido");
        cliente.setDataNascimento(LocalDate.now().plusDays(1)); // data futura

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<Cliente>> violacoes = validator.validate(cliente);

        if (!violacoes.isEmpty()) {
            System.out.println("Erros encontrados:");
            for (ConstraintViolation<Cliente> v : violacoes) {
                System.out.println("- " + v.getMessage());
            }
        } else {
            System.out.println("Cliente válido!");
        }
    }
}
