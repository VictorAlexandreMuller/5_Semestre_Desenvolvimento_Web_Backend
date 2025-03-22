package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Funcionario;
import com.example.demo.repositories.FuncionarioRepository;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public List<Funcionario> listarTodos() {
        return funcionarioRepository.findAll();
    }

    public Funcionario buscarPorId(Long id) {
        return funcionarioRepository.findById(id).orElseThrow(() -> 
            new RuntimeException("Funcionário com ID " + id + " não encontrado."));
    }

    public Funcionario salvar(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    public void deletar(Long id) {
        if (!funcionarioRepository.existsById(id)) {
            throw new RuntimeException("Funcionário com ID " + id + " não encontrado.");
        }
        funcionarioRepository.deleteById(id);
    }    
    
    public Funcionario atualizar(Long id, Funcionario funcionarioAtualizado) {
        Funcionario funcionario = funcionarioRepository.findById(id).orElseThrow(() -> 
            new RuntimeException("Funcionário com ID " + id + " não encontrado."));
        
        funcionario.setNome(funcionarioAtualizado.getNome());
        funcionario.setCargo(funcionarioAtualizado.getCargo());
        
        return funcionarioRepository.save(funcionario);
    }

    
}
