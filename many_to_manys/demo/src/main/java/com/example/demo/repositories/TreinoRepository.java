package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Treino;

public interface TreinoRepository extends JpaRepository<Treino, Long> {
    
    // Buscar treinos por aluno
    List<Treino> findByAlunoId(Long alunoId);

}