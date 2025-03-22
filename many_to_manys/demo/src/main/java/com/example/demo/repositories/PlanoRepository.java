package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Plano;

public interface PlanoRepository extends JpaRepository<Plano, Long> {
}
