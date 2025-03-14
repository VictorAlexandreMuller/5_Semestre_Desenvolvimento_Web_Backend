package com.example.cadastroCliente.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cadastroCliente.model.Cliente;
import com.example.cadastroCliente.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	@Autowired
	private ClienteService clienteService;

// Endpoint para adicionar um cliente
	@PostMapping("/adicionar")
	public String adicionarCliente(@RequestBody Cliente cliente) {
		clienteService.adicionarCliente(cliente);
		return "Cliente adicionado com sucesso!";
	}

// Endpoint para listar todos os clientes
	@GetMapping("/listar")
	public List<Cliente> listarClientes() {
		return clienteService.listarClientes();
	}

}