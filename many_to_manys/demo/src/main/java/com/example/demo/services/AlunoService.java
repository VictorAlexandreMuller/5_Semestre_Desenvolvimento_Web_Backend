package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Aluno;
import com.example.demo.repositories.AlunoRepository;
import com.example.demo.repositories.FuncionarioRepository;
import com.example.demo.repositories.PlanoRepository;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private PlanoRepository planoRepository;

    public List<Aluno> listarTodos() {
        return alunoRepository.findAll();
    }

    public Aluno buscarPorId(Long id) {
        return alunoRepository.findById(id).orElseThrow(() -> 
            new RuntimeException("Aluno com ID " + id + " não encontrado."));
    }

    public Aluno salvar(Aluno aluno) {
        if (aluno.getPlano() != null && aluno.getPlano().getId() != null) {
            if (!planoRepository.existsById(aluno.getPlano().getId())) {
                throw new RuntimeException("Plano com ID " + aluno.getPlano().getId() + " não existe.");
            }
        }
        return alunoRepository.save(aluno);
    }

    public void deletar(Long id) {
        if (!alunoRepository.existsById(id)) {
            throw new RuntimeException("Aluno com ID " + id + " não encontrado.");
        }
        alunoRepository.deleteById(id);
    }

    public Aluno atualizar(Long id, Aluno alunoAtualizado) {
        Aluno aluno = alunoRepository.findById(id).orElseThrow(() -> 
            new RuntimeException("Aluno com ID " + id + " não encontrado."));
        
        aluno.setNome(alunoAtualizado.getNome());
        aluno.setIdade(alunoAtualizado.getIdade());
        aluno.setPlano(alunoAtualizado.getPlano());
    
        return alunoRepository.save(aluno);
    }
    
    
}
