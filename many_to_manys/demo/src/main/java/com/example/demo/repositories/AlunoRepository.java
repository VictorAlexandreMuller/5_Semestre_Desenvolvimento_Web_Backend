package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
