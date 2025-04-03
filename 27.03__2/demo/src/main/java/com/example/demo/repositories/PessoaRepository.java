package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    List<Pessoa> findBySalarioGreaterThan(Double salario);

    List<Pessoa> findBySalarioLessThanEqual(Double salario);

    List<Pessoa> findByNomeStartingWith(String nome);

}
