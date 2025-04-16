package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.models.Reserva;
import com.example.demo.repositories.ReservaRepository;

@Service
public class ReservaService {
    private final ReservaRepository repo;

    public ReservaService(ReservaRepository repo) {
        this.repo = repo;
    }

    public List<Reserva> listarTodas() {
        return repo.findAll();
    }

    public Reserva salvar(Reserva reserva) {
        boolean conflito = !repo.verificarConflitos(
                reserva.getQuarto().getId(),
                reserva.getDataEntrada(),
                reserva.getDataSaida()
        ).isEmpty();

        if (conflito) {
            throw new RuntimeException("Já existe uma reserva para esse quarto no período selecionado.");
        }

        return repo.save(reserva);
    }

    public void deletar(Long id) {
        repo.deleteById(id);
    }
}
