package com.example.cadastroCliente.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.cadastroCliente.model.Cliente;

@Service
public class ClienteService {
	private List<Cliente> clientes = new ArrayList<>();

	public void adicionarCliente(Cliente cliente) {
		clientes.add(cliente);
	}

	public List<Cliente> listarClientes() {
		return clientes;
	}
}