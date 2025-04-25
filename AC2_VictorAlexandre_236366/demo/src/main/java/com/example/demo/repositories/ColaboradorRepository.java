package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Colaborador;

public interface ColaboradorRepository extends JpaRepository<Colaborador, Long> {
    
}
