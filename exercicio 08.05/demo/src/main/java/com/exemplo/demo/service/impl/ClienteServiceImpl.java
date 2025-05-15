package com.exemplo.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.exemplo.demo.dto.ClienteDTO;
import com.exemplo.demo.dto.ClienteRequestDTO;
import com.exemplo.demo.model.Cliente;
import com.exemplo.demo.repository.ClienteRepository;
import com.exemplo.demo.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public ClienteDTO criarCliente(ClienteRequestDTO dto) {
        Cliente cliente = new Cliente();
        cliente.setNome(dto.getNome());
        cliente.setEmail(dto.getEmail());

        Cliente salvo = clienteRepository.save(cliente);

        return new ClienteDTO(salvo.getId(), salvo.getNome(), salvo.getEmail());
    }

    @Override
    public List<ClienteDTO> listarClientes() {
        return clienteRepository.findAll().stream()
                .map(c -> new ClienteDTO(c.getId(), c.getNome(), c.getEmail()))
                .collect(Collectors.toList());
    }
}
