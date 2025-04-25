package com.example.demo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Projeto;
import com.example.demo.services.ProjetoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/projetos")
@RequiredArgsConstructor
public class ProjetoController {

    private final ProjetoService projetoService;

    @PostMapping("/{clienteId}")
    public Projeto salvar(@PathVariable Long clienteId, @RequestBody Projeto projeto) {
        return projetoService.salvar(clienteId, projeto);
    }

    @GetMapping
    public List<Projeto> listar() {
        return projetoService.listarTodos();
    }

    @PutMapping("/{id}/status")
    public Projeto atualizarStatus(@PathVariable Long id, @RequestParam String status) {
        return projetoService.atualizarStatus(id, status);
    }

    @PutMapping("/{id}/atribuir")
    public Projeto atribuirColaboradores(@PathVariable Long id, @RequestBody List<Long> colaboradoresIds) {
        return projetoService.atribuirColaboradores(id, colaboradoresIds);
    }
}
