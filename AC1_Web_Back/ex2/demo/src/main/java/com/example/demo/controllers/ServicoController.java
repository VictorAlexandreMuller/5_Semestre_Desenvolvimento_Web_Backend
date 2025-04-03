package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Servico;
import com.example.demo.repositories.AnimalRepository;
import com.example.demo.repositories.ClienteRepository;
import com.example.demo.repositories.ServicoRepository;

@RestController
@RequestMapping("/servicos")
public class ServicoController {

    @Autowired
    private ServicoRepository servicoRepo;

    @Autowired
    private ClienteRepository clienteRepo;

    @Autowired
    private AnimalRepository animalRepo;

    @GetMapping
    public List<Servico> listarTodos() {
        return servicoRepo.findAll();
    }

    @PostMapping
    public ResponseEntity<Servico> criar(@RequestBody Servico servico) {
        if (servico.getCliente() == null || servico.getCliente().getId() == null
                || !clienteRepo.existsById(servico.getCliente().getId())) {
            return ResponseEntity.badRequest().body(null);
        }

        if (servico.getAnimal() == null || servico.getAnimal().getId() == null
                || !animalRepo.existsById(servico.getAnimal().getId())) {
            return ResponseEntity.badRequest().body(null);
        }

        return ResponseEntity.ok(servicoRepo.save(servico));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Servico> buscarPorId(@PathVariable Long id) {
        return servicoRepo.findById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!servicoRepo.existsById(id)) return ResponseEntity.notFound().build();
        servicoRepo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
