package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculadora")
public class CalculadoraController {

// Alt Shift F formata identação

    @GetMapping("/somar")
    public double somar(@RequestBody List<Double> numeros) {

        Double soma = numeros.get(0) + numeros.get(1);

        return soma;
    }

    @GetMapping("/subtrair")
    public double subtrair(@RequestBody List<Double> numeros) {

        Double subtrair = numeros.get(0) - numeros.get(1);

        return subtrair;
    }

    @GetMapping("/multiplicar/{numero1}/{numero2}")
    public double multiplicar(@PathVariable double numero1, @PathVariable double numero2) {

        Double multiplicar = numero1 * numero2;

        return multiplicar;
    }

    @GetMapping("/dividir")
    public double dividir(@RequestBody List<Double> numeros) {

        if (numeros.get(1) == 0) {
            throw new RuntimeException("Zero não divide :/");
        } else {
            Double dividir = numeros.get(0) / numeros.get(1);

            return dividir;
        }

    }

}
