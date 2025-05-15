package com.exemplo.demo.service;

import java.util.List;

import com.exemplo.demo.dto.ClienteDTO;
import com.exemplo.demo.dto.ClienteRequestDTO;

public interface ClienteService {
    ClienteDTO criarCliente(ClienteRequestDTO dto);
    List<ClienteDTO> listarClientes();
}
