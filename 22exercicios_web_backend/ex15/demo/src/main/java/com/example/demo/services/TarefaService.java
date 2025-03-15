package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.models.Tarefa;
import com.example.demo.repositories.TarefaRepository;

@Service
public class TarefaService {

	private TarefaRepository repository;

	public TarefaService(TarefaRepository repository) {
		this.repository = repository;
	}
	
	public List<Tarefa> obterTarefas() {
		return repository.findAll();
	}
	
	public Tarefa obterPorId(Long id) {
		Optional<Tarefa> buscarTarefa =  repository.findById(id);
		
		if (buscarTarefa.isPresent()) {
			return buscarTarefa.get();
		} else {
			throw new RuntimeException("Não foi possível encontrar a Tarefa desejada.");
		}
	}
	
	public Tarefa cadastrarTarefa(Tarefa novaTarefa) {
		Tarefa tarefadb = repository.save(novaTarefa);
		
		return tarefadb;
	}
	
	public Tarefa editarTarefa(Long id, Tarefa editTarefa) {
		Tarefa tarefa = obterPorId(id);
		
		editTarefa.setId(id);
		return repository.save(editTarefa);
	}
	
	public String excluirTarefa(Long id) {
		Tarefa tarefa = obterPorId(id);

		repository.delete(tarefa);
		
		return "Tarefa excluída.";
	}
}
