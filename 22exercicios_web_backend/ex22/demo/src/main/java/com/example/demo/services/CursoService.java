package com.example.demo.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.models.Curso;
import com.example.demo.repositories.CursoRepository;

@Service
public class CursoService {

	private CursoRepository repository;

	public CursoService(CursoRepository repository) {
		this.repository = repository;
	}
	
	public List<Curso> listarCursos() {
		return repository.findAll();
	}
	
	public Curso obterPorId(Long id) {
		Optional<Curso> buscarCurso = repository.findById(id);
		
		if (buscarCurso.isPresent()) {
			return buscarCurso.get();
		} else {
			throw new RuntimeException("Não foi possível encontrar o curso.");
		}
	}
	
	public Curso registrarCurso(Curso curso) {
		curso.setDataCriacao(LocalDate.now());
		Curso cursodb = repository.save(curso);
		
		return cursodb;
	}
	
	public Curso editarCurso(Long id, Curso editCurso) {
		Curso buscarCurso = obterPorId(id);
		
		editCurso.setId(id);
		editCurso.setDataCriacao(buscarCurso.getDataCriacao());
		return repository.save(editCurso);
	}
	
	public String excluirCurso(Long id) {
		Curso buscarCurso = obterPorId(id);
		
		repository.delete(buscarCurso);
		return "Curso excluído.";
	}
}