package com.example.demo.services;

import com.example.demo.models.Quarto;
import com.example.demo.repositories.QuartoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuartoService {
    private final QuartoRepository repo;

    public QuartoService(QuartoRepository repo) {
        this.repo = repo;
    }

    public List<Quarto> listarTodos() {
        return repo.findAll();
    }

    public Quarto salvar(Quarto quarto) {
        return repo.save(quarto);
    }

    public Quarto buscarPorId(Long id) {
        return repo.findById(id).orElse(null);
    }

    public void deletar(Long id) {
        repo.deleteById(id);
    }
}
