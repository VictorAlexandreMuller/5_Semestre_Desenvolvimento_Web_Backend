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

import com.example.demo.models.Tarefa;
import com.example.demo.services.TarefaService;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

	private TarefaService service;

	public TarefaController(TarefaService service) {
		this.service = service;
	}
	
	@GetMapping
	public List<Tarefa> obterTarefas() {
		return service.obterTarefas();
	}
	
	@GetMapping("/{id}")
	public Tarefa obterTarefas(@PathVariable Long id) {
		return service.obterPorId(id);
	}
	
	@PostMapping
	public Tarefa cadastrarTarefa(@RequestBody Tarefa tarefa) {
		return service.cadastrarTarefa(tarefa);
	}
	
	@PutMapping("/{id}")
	public Tarefa editarTarefa(@PathVariable Long id, @RequestBody Tarefa tarefa) {
		return service.editarTarefa(id, tarefa);
	}
	
	@DeleteMapping("/{id}")
	public String excluirTarefa(@PathVariable Long id) {
		return service.excluirTarefa(id);
	}

}
