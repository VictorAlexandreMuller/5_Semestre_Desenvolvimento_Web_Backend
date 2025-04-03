package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.models.Pessoa;
import com.example.demo.repositories.PessoaRepository;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(PessoaRepository repository) {
		return (_args) -> {
			
			repository.save(new Pessoa("Ana", 2500.0));
			repository.save(new Pessoa("André", 1500.0));
			repository.save(new Pessoa("Bruna", 3200.0));
			repository.save(new Pessoa("Carlos", 1000.0));
			repository.save(new Pessoa("Daniel", 4500.0));
			repository.save(new Pessoa("Alice", 1800.0));

			System.out.println("Pessoas com salário maior que 2000:");
			repository.findBySalarioGreaterThan(2000.0).forEach(System.out::println);

			System.out.println("\nPessoas com salário menor ou igual a 1800:");
			repository.findBySalarioLessThanEqual(1800.0).forEach(System.out::println);

			System.out.println("\nPessoas que começam com 'A':");
			repository.findByNomeStartingWith("A").forEach(System.out::println);
		};
	}
}
