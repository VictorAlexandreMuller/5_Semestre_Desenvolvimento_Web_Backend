package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Servico;

public interface ServicoRepository extends JpaRepository<Servico, Long> {
}
