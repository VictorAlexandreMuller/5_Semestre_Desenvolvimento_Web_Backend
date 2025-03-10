package com.example.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.Repository.CategoriaCursoRepository;
import com.example.demo.model.CategoriaCurso;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	
	private CategoriaCursoRepository repository;

	// @Autowired
	public DemoApplication(CategoriaCursoRepository repository) {
		this.repository = repository;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        List<CategoriaCurso> categoriaCurso = Arrays.asList(
			new CategoriaCurso(null, "Pedro"),
			new CategoriaCurso(null, "Pedro Henrique"),
			new CategoriaCurso(null, "Ricardo"),
			new CategoriaCurso(null, "Nicolas"),
			new CategoriaCurso(null, "Leo")


			);

			categoriaCurso.forEach(c -> repository.inserir(c));
			
			repository.excluir(4);
			repository.editar(new CategoriaCurso(5L, "Leonardo"));
			
			var catecurso = repository.obterTodos();
			
			catecurso.forEach(System.out::println);
			
			var buscarNome = repository.obterPorNome("Pedro");
			
			System.out.printf("%nObtendo por nome:%n");
			buscarNome.forEach(System.out::println);
		
    }

}
