package com.example.demo.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Venda;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {

    List<Venda> findByDescricaoProdutoContainingIgnoreCase(String nomeCliente);

    List<Venda> findByValorTotalGreaterThan(Double valor);

    List<Venda> findByDataVendaBetween(LocalDateTime inicio, LocalDateTime fim);

    List<Venda> findByProdutoId(Long produtoId);

    List<Venda> findByClienteId(Long clienteId);

}
