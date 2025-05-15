package com.exemplo.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exemplo.demo.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
