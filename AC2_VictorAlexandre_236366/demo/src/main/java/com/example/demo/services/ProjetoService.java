package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.models.Cliente;
import com.example.demo.models.Colaborador;
import com.example.demo.models.Projeto;
import com.example.demo.repositories.ClienteRepository;
import com.example.demo.repositories.ColaboradorRepository;
import com.example.demo.repositories.ProjetoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProjetoService {

    private final ProjetoRepository projetoRepository;
    private final ClienteRepository clienteRepository;
    private final ColaboradorRepository colaboradorRepository;

    public Projeto salvar(Long clienteId, Projeto projeto) {
        Cliente cliente = clienteRepository.findById(clienteId)
            .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado com ID " + clienteId));
        projeto.setCliente(cliente);
        return projetoRepository.save(projeto);
    }

    public List<Projeto> listarTodos() {
        return projetoRepository.findAll();
    }

    public Projeto atualizarStatus(Long projetoId, String status) {
        Projeto projeto = projetoRepository.findById(projetoId).orElseThrow();
        projeto.setStatus(status);
        return projetoRepository.save(projeto);
    }

    public Projeto atribuirColaboradores(Long projetoId, List<Long> colaboradoresIds) {
        Projeto projeto = projetoRepository.findById(projetoId).orElseThrow();
        List<Colaborador> colaboradores = colaboradorRepository.findAllById(colaboradoresIds);
        projeto.getColaboradores().addAll(colaboradores);
        return projetoRepository.save(projeto);
    }
}
