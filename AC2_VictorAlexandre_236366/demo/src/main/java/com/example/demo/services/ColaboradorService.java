package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.models.Colaborador;
import com.example.demo.repositories.ColaboradorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ColaboradorService {
    private final ColaboradorRepository colaboradorRepository;

    public Colaborador salvar(Colaborador colaborador) {
        return colaboradorRepository.save(colaborador);
    }

    public List<Colaborador> listarTodos() {
        return colaboradorRepository.findAll();
    }
}
