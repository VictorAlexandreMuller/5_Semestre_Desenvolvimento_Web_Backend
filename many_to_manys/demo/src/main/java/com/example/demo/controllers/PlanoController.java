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

import com.example.demo.models.Plano;
import com.example.demo.services.PlanoService;

@RestController
@RequestMapping("/planos")
public class PlanoController {

    @Autowired
    private PlanoService planoService;

    @GetMapping
    public List<Plano> listarTodos() {
        return planoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Plano buscarPorId(@PathVariable Long id) {
        return planoService.buscarPorId(id);
    }

    @PostMapping
    public Plano criar(@RequestBody Plano plano) {
        return planoService.salvar(plano);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        planoService.deletar(id);
    }

    @PutMapping("/{id}")
    public Plano atualizar(@PathVariable Long id, @RequestBody Plano plano) {
        return planoService.atualizar(id, plano);
    }

}
