package com.example.demo.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    List<Produto> findByPrecoGreaterThan(Double preco);

    List<Produto> findBySetorIgnoreCase(String setor);

    List<Produto> findByValidadeAfter(LocalDate data);
}
