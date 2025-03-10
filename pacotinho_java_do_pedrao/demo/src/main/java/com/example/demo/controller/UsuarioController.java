package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import com.example.demo.model.Usuario;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	private List<Usuario> usuarios;

	@Autowired
	public UsuarioController() {
		this.usuarios = new ArrayList<Usuario>();
	}

	@GetMapping
	public List<Usuario> findAll() {
		return usuarios;
	}

	@PostMapping
	public Usuario registrar(@RequestBody Usuario usuario) {
		usuarios.add(usuario);

		return usuarios.getLast();

	}

	@PutMapping("/{id}")
	public Usuario editar(@PathVariable Integer id, @RequestBody Usuario usuario) {
		usuarios.get(id).setNome(usuario.getNome());
		usuarios.get(id).setCpf(usuario.getCpf());
		usuarios.get(id).setIdade(usuario.getIdade());
		
		return usuarios.get(id);
	}
	
	@DeleteMapping("/{id}")
	public String deletar(@PathVariable Integer id) {
		Usuario findUsuario = usuarios.get(id);
		if (findUsuario != null) {
			usuarios.remove(findUsuario);
			
			return "Usuário apagado com sucesso!";
		} else {
			return "Usuário não encontrado!";
		}
		
	}

}
