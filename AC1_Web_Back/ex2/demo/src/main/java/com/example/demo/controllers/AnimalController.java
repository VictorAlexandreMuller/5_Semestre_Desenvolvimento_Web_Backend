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

import com.example.demo.models.Animal;
import com.example.demo.repositories.AnimalRepository;
import com.example.demo.repositories.ClienteRepository;

@RestController
@RequestMapping("/animais")
public class AnimalController {

    @Autowired
    private AnimalRepository animalRepo;

    @Autowired
    private ClienteRepository clienteRepo;

    @GetMapping
    public List<Animal> listarTodos() {
        return animalRepo.findAll();
    }

    @PostMapping
    public ResponseEntity<Animal> criar(@RequestBody Animal animal) {
        if (animal.getCliente() == null || animal.getCliente().getId() == null
                || !clienteRepo.existsById(animal.getCliente().getId())) {
            return ResponseEntity.badRequest().build(); // Cliente obrigatório
        }
        return ResponseEntity.ok(animalRepo.save(animal));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Animal> buscarPorId(@PathVariable Long id) {
        return animalRepo.findById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!animalRepo.existsById(id)) return ResponseEntity.notFound().build();
        animalRepo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
