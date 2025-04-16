package com.example.demo.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.models.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    @Query("SELECT r FROM Reserva r WHERE r.quarto.id = :quartoId AND " +
           "(r.dataEntrada < :dataSaida AND r.dataSaida > :dataEntrada)")
    List<Reserva> verificarConflitos(Long quartoId, LocalDate dataEntrada, LocalDate dataSaida);
}
