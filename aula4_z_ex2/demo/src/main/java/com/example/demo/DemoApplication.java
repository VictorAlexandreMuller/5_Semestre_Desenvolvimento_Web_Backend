package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.Repository.MedicamentoRepository;
import com.example.demo.model.Medicamento;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	private MedicamentoRepository repository;
	
	public DemoApplication(MedicamentoRepository repository) {
		this.repository = repository;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Medicamento> medicamentos = Arrays.asList(
				new Medicamento(null, "Cataflam", "Ultra", new BigDecimal(10), LocalDate.of(2020, 10, 05)),
				new Medicamento(null, "Ambroxol", "Farma", new BigDecimal(100), LocalDate.of(2021, 9, 04)),
				new Medicamento(null, "Nimesulida", "Ultra", new BigDecimal(20), LocalDate.of(2022, 8,03)),
				new Medicamento(null, "Polaramine", "Farma", new BigDecimal(99), LocalDate.of(2023, 7, 02)),
				new Medicamento(null, "Musculare", "LabLab", new BigDecimal(80), LocalDate.of(2024, 6, 01))
				);
		
		var medicamentosDb = repository.saveAll(medicamentos);
		
		medicamentosDb.forEach(System.out::println);
		String x = "la";
		
		System.out.printf("%nBuscar por nome:%n '%s'.%n", x);
		var buscarMedicamentoNome = repository.findByNomeContaining(x);
		System.out.println(buscarMedicamentoNome);
		
		System.out.printf("%nBuscar por Laboratório:%n");
		var buscarMedicamentoLab = repository.findByLaboratorio("Ultra"); 
		buscarMedicamentoLab.forEach(System.out::println);
		
		System.out.printf("%nBuscar por Validade:%n");
		var buscarMedicamentoValidade = repository.findByDataValidadeBefore(LocalDate.of(2022, 10, 05));
		buscarMedicamentoValidade.forEach(System.out::println);
		
	}
}
