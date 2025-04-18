package com.example.demo.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.DTOs.PedidoDTO;
import com.example.demo.models.Cliente;
import com.example.demo.models.Pedido;
import com.example.demo.models.SaborBolo;
import com.example.demo.repositories.ClienteRepository;
import com.example.demo.repositories.PedidoRepository;
import com.example.demo.repositories.SaborBoloRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;
    private final SaborBoloRepository saborBoloRepository;

    @Override
    @Transactional
    public Pedido criarPedido(PedidoDTO dto) {
        Cliente cliente = clienteRepository.findById(dto.getClienteId())
            .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        SaborBolo sabor = saborBoloRepository.findById(dto.getSaborId())
            .orElseThrow(() -> new RuntimeException("Sabor de bolo não encontrado"));

        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        pedido.setSabor(sabor);
        pedido.setStatus(Pedido.StatusPedido.valueOf(dto.getStatus().toUpperCase()));
        pedido.setDataPedido(LocalDate.now());

        return pedidoRepository.save(pedido);
    }

    @Override
    public Pedido atualizarStatus(Long id, String novoStatus) {
        Pedido pedido = pedidoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

        pedido.setStatus(Pedido.StatusPedido.valueOf(novoStatus.toUpperCase()));
        return pedidoRepository.save(pedido);
    }

    @Override
    public List<Pedido> listarTodos() {
        return pedidoRepository.findAll();
    }
}