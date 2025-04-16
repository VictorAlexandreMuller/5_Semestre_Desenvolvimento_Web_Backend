package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.models.Cliente;
import com.example.demo.repositories.ClienteRepository;

@Service
public class ClienteService {
    private final ClienteRepository repo;

    public ClienteService(ClienteRepository repo) {
        this.repo = repo;
    }

    public List<Cliente> listarTodos() {
        return repo.findAll();
    }

    public Cliente salvar(Cliente cliente) {
        return repo.save(cliente);
    }

    public Cliente buscarPorId(Long id) {
        return repo.findById(id).orElse(null);
    }

    public void deletar(Long id) {
        repo.deleteById(id);
    }
    
    public Cliente atualizar(Long id, Cliente clienteAtualizado) {
        Cliente cliente = repo.findById(id)
            .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    
        cliente.setNome(clienteAtualizado.getNome());
        cliente.setCpf(clienteAtualizado.getCpf());
        cliente.setTelefone(clienteAtualizado.getTelefone());
    
        return repo.save(cliente);
    }
    
}
