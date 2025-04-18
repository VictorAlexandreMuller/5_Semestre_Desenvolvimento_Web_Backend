package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.SaborBolo;

@Repository
public interface SaborBoloRepository extends JpaRepository<SaborBolo, Long> {
    
}
