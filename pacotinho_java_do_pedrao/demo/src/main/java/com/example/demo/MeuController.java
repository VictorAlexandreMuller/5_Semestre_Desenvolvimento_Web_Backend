package com.example.demo;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MeuController {

    @GetMapping(value = "/")
    public String getMethodName() {
        return "Olá Mundo";
    }

    @GetMapping("/ teste ")
    public String getData(@RequestParam(value = "param") String paramValue) {
        return "O valor do parâmetro é: " + paramValue;
    }

    @GetMapping("/testePath/{param}")
    public String getDataPath(@PathVariable("param") String paramValue) {
        return "O valor do parâmetro é: " + paramValue;
    }

    @PostMapping("/somar")
    public Double somarPost(@RequestParam("n1") double number1, @RequestParam("n2") double number2) {
    double soma = number1 + number2;
        return soma;
    }

    public class NumeroDTO {
        public NumeroDTO() {
        }
        public NumeroDTO(Double numero1, Double numero2) {
        this.numero1 = numero1;
        this.numero2 = numero2;
        }
        private Double numero1;
        private Double numero2;
        public Double getNumero1() {
        return numero1;
        }
        public void setNumero1(Double numero1) {
        this.numero1 = numero1;
        }
        public double getNumero2() {
        return numero2;
        }
        public void setNumero2(Double numero2) {
        this.numero2 = numero2;
        }
    }

    @PostMapping("/somarDTO")
    public Double createProduct(@RequestBody NumeroDTO numeros) {
        return numeros.getNumero1() + numeros.getNumero2();
    }

    @PutMapping("/multiplicar")
    public double multiplyNumbers(@RequestParam("number1") double number1, @RequestParam("number2") double number2) {
        return number1 * number2;
    }

    @DeleteMapping("/produto/{id}")
    public String deleteRecord(@PathVariable("id") Long id) {
        return "Id excluído: " + id;
    }

}
