package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

}
