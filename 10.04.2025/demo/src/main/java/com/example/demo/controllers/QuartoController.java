package com.example.demo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Quarto;
import com.example.demo.models.QuartoNormal;
import com.example.demo.models.QuartoVip;
import com.example.demo.services.QuartoService;

@RestController
@RequestMapping("/api/quartos")
public class QuartoController {
    private final QuartoService service;

    public QuartoController(QuartoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Quarto> listar() {
        return service.listarTodos();
    }

    @PostMapping("/normal")
    public Quarto salvarNormal(@RequestBody QuartoNormal quarto) {
        return service.salvar(quarto);
    }

    @PostMapping("/vip")
    public Quarto salvarVip(@RequestBody QuartoVip quarto) {
        return service.salvar(quarto);
    }

    @GetMapping("/{id}")
    public Quarto buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        service.deletar(id);
    }
}
