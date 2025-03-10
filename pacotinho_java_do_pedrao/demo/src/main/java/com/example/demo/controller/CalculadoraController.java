package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculadora")
public class CalculadoraController {

	@GetMapping("/somar")
	public Double somar(@RequestBody List<Double> numeros) {
		Double sum = numeros.get(0) + numeros.get(1);
		
		return sum;
	}
	
	@GetMapping("/subtrair")
	public Double subtrair(@RequestBody List<Double> numeros) {
		Double sub = numeros.get(0) - numeros.get(1);
		
		return sub;
	}
	
	@GetMapping("/multiplicar")
	public Double multiplicar(@RequestBody List<Double> numeros) {
		Double mult = numeros.get(0) * numeros.get(1);
		
		return mult;
	}
	@GetMapping("/dividir")
	public Double dividir(@RequestBody List<Double> numeros) {
		if (numeros.get(1) == 0) {
			throw new RuntimeException("Não é possível dividir por zero.");
		}
		
		Double div = numeros.get(0) / numeros.get(1);
		
		return div;
	}
}
