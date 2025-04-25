package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Projeto;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
    
}
