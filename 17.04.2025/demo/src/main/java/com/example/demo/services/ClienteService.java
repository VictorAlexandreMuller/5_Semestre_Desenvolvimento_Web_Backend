package com.example.demo.services;

import java.util.List;

import com.example.demo.models.Cliente;

public interface ClienteService {
    Cliente salvar(Cliente cliente);
    List<Cliente> listarTodos();
}
