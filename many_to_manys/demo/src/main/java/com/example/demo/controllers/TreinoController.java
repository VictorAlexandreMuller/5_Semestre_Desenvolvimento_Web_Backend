package com.example.demo.controllers;

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

import com.example.demo.models.Treino;
import com.example.demo.services.TreinoService;

@RestController
@RequestMapping("/treinos")
public class TreinoController {

    @Autowired
    private TreinoService treinoService;

    @GetMapping
    public List<Treino> listarTodos() {
        return treinoService.listarTodos();
    }

    @GetMapping("/aluno/{alunoId}")
    public List<Treino> listarPorAluno(@PathVariable Long alunoId) {
        return treinoService.listarPorAluno(alunoId);
    }

    @PostMapping
    public Treino criar(@RequestBody Treino treino) {
        return treinoService.salvar(treino);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        treinoService.deletar(id);
    }

    @PutMapping("/{id}")
    public Treino atualizar(@PathVariable Long id, @RequestBody Treino treino) {
        return treinoService.atualizar(id, treino);
    }

}
