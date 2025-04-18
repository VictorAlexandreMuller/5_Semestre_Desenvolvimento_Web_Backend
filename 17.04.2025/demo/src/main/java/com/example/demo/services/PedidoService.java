package com.example.demo.services;

import java.util.List;

import com.example.demo.DTOs.PedidoDTO;
import com.example.demo.models.Pedido;

public interface PedidoService {
    Pedido criarPedido(PedidoDTO dto);
    Pedido atualizarStatus(Long id, String status);
    List<Pedido> listarTodos();
}