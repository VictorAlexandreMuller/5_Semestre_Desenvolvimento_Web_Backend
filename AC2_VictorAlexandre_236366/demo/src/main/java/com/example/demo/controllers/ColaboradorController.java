package com.example.demo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Colaborador;
import com.example.demo.services.ColaboradorService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/colaboradores")
@RequiredArgsConstructor
public class ColaboradorController {
    private final ColaboradorService colaboradorService;

    @PostMapping
    public Colaborador salvar(@RequestBody Colaborador colaborador) {
        return colaboradorService.salvar(colaborador);
    }

    @GetMapping
    public List<Colaborador> listar() {
        return colaboradorService.listarTodos();
    }
}
