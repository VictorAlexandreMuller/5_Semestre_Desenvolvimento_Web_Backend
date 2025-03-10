package com.example.demo.controller;

import java.util.ArrayList;
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

import com.example.demo.classes.Usuario;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private List<Usuario> listaUsuarios;

    @Autowired
	public UsuarioController() {
		this.listaUsuarios = new ArrayList<Usuario>();
	}

	@GetMapping
	public List<Usuario> findAll() {
		return listaUsuarios;
	}

	@PostMapping
	public Usuario registrar(@RequestBody Usuario usuario) {
		listaUsuarios.add(usuario);

		return listaUsuarios.getLast();

	}

	@PutMapping("/{id}")
	public Usuario editar(@PathVariable Integer id, @RequestBody Usuario usuario) {
		listaUsuarios.get(id).setNome(usuario.getNome());
		listaUsuarios.get(id).setIdade(usuario.getIdade());
        listaUsuarios.get(id).setGenero(usuario.getGenero());
		
		return listaUsuarios.get(id);
	}
	
	@DeleteMapping("/{id}")
	public String deletar(@PathVariable Integer id) {
		Usuario findUsuario = listaUsuarios.get(id);
		if (findUsuario != null) {
			listaUsuarios.remove(findUsuario);
			
			return "O usuário foi apagado com sucesso.";
		} else {
			return "O usuário não foi encontrado.";
		}
		
	}

}
