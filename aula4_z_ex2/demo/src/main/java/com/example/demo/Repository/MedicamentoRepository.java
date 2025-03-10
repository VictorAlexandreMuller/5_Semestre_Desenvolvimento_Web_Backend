package com.example.demo.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Medicamento;

@Repository
public interface MedicamentoRepository extends JpaRepository<Medicamento, Long> {

    List<Medicamento> findByNomeContaining(String nome);

    List<Medicamento> findByLaboratorio(String laboratorio);

    List<Medicamento> findByDataValidadeBefore(LocalDate data);
}
