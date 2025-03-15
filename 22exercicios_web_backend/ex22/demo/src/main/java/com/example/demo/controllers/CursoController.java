package com.example.demo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Curso;
import com.example.demo.services.CursoService;

@RestController
@RequestMapping("/cursos")
public class CursoController {

	private CursoService service;

	public CursoController(CursoService service) {
		this.service = service;
	}

	@GetMapping
	public List<Curso> listarCursos() {
		return service.listarCursos();
	}

	@GetMapping("/{id}")
	public Curso obterPorId(@PathVariable Long id) {
		return service.obterPorId(id);
	}

	@PostMapping
	public Curso criarCurso(@RequestBody Curso curso) {
		return service.registrarCurso(curso);
	}
	
	@PutMapping("/{id}")
	public Curso editarCurso(@PathVariable Long id, @RequestBody Curso editCurso) {
		return service.editarCurso(id, editCurso);
	}
	
	@DeleteMapping("/{id}")
	public String excluirCurso(@PathVariable Long id) {
		return service.excluirCurso(id);
	}
}