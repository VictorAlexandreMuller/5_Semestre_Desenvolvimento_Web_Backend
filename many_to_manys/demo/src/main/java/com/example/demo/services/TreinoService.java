package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Treino;
import com.example.demo.repositories.AlunoRepository;
import com.example.demo.repositories.TreinoRepository;

@Service
public class TreinoService {

    @Autowired
    private TreinoRepository treinoRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    public List<Treino> listarTodos() {
        return treinoRepository.findAll();
    }

    public List<Treino> listarPorAluno(Long alunoId) {
        return treinoRepository.findByAlunoId(alunoId);
    }

    public Treino salvar(Treino treino) {
        if (treino.getAluno() == null || treino.getAluno().getId() == null) {
            throw new RuntimeException("Treino precisa estar vinculado a um aluno.");
        }

        if (!alunoRepository.existsById(treino.getAluno().getId())) {
            throw new RuntimeException("Aluno com ID " + treino.getAluno().getId() + " não encontrado.");
        }

        return treinoRepository.save(treino);
    }

    public void deletar(Long id) {
        if (!treinoRepository.existsById(id)) {
            throw new RuntimeException("Treino com ID " + id + " não encontrado.");
        }
        treinoRepository.deleteById(id);
    }

    public Treino atualizar(Long id, Treino treinoAtualizado) {
        Treino treino = treinoRepository.findById(id).orElseThrow(() -> 
            new RuntimeException("Treino com ID " + id + " não encontrado."));
        
        treino.setDescricao(treinoAtualizado.getDescricao());
        treino.setData(treinoAtualizado.getData());
    
        return treinoRepository.save(treino);
    }    
    
}
