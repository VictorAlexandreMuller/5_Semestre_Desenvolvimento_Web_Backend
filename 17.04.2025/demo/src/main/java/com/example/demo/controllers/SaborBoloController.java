package com.example.demo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.SaborBolo;
import com.example.demo.repositories.SaborBoloRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/sabores")
@RequiredArgsConstructor
public class SaborBoloController {

    private final SaborBoloRepository saborBoloRepository;

    @GetMapping
    public List<SaborBolo> listar() {
        return saborBoloRepository.findAll();
    }

    @PostMapping
    public SaborBolo criar(@RequestBody SaborBolo sabor) {
        return saborBoloRepository.save(sabor);
    }
}
