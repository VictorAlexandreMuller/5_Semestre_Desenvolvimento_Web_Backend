package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Treino;
import com.example.demo.repositories.TreinoRepository;

@RestController
@RequestMapping("/treinos")
public class TreinoController {

    @Autowired
    private TreinoRepository treinoRepository;

    @GetMapping
    public List<Treino> listarTodos() {
        return treinoRepository.findAll();
    }

    @GetMapping("/aluno/{alunoId}")
    public List<Treino> listarPorAluno(@PathVariable Long alunoId) {
        return treinoRepository.findByAlunoId(alunoId);
    }

    @PostMapping
    public Treino criar(@RequestBody Treino treino) {
        return treinoRepository.save(treino);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        treinoRepository.deleteById(id);
    }
}
