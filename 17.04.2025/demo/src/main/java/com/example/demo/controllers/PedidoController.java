package com.example.demo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTOs.PedidoDTO;
import com.example.demo.models.Pedido;
import com.example.demo.services.PedidoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/pedidos")
@RequiredArgsConstructor
public class PedidoController {
    private final PedidoService pedidoService;

    @PostMapping
    public Pedido criarPedido(@RequestBody PedidoDTO dto) {
        return pedidoService.criarPedido(dto);
    }

    @PatchMapping("/{id}/status")
    public Pedido atualizarStatus(@PathVariable Long id, @RequestParam String status) {
        return pedidoService.atualizarStatus(id, status);
    }

    @GetMapping
    public List<Pedido> listar() {
        return pedidoService.listarTodos();
    }
}
