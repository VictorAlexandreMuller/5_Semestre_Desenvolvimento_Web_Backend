package com.example.demo.controllers;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.ReservaDTO;
import com.example.demo.models.Cliente;
import com.example.demo.models.Quarto;
import com.example.demo.models.Reserva;
import com.example.demo.repositories.ClienteRepository;
import com.example.demo.repositories.QuartoRepository;
import com.example.demo.services.ReservaService;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

    private final ReservaService service;
    private final ClienteRepository clienteRepo;
    private final QuartoRepository quartoRepo;

    public ReservaController(ReservaService service, ClienteRepository clienteRepo, QuartoRepository quartoRepo) {
        this.service = service;
        this.clienteRepo = clienteRepo;
        this.quartoRepo = quartoRepo;
    }

    @GetMapping
    public List<Reserva> listar() {
        return service.listarTodas();
    }

    @PostMapping
    public Reserva salvar(@RequestBody ReservaDTO dto) {
        Optional<Cliente> clienteOpt = clienteRepo.findById(dto.getClienteId());
        Optional<Quarto> quartoOpt = quartoRepo.findById(dto.getQuartoId());

        if (clienteOpt.isEmpty() || quartoOpt.isEmpty()) {
            throw new RuntimeException("Cliente ou Quarto não encontrado.");
        }

        Cliente cliente = clienteOpt.get();
        Quarto quarto = quartoOpt.get();
        LocalDate entrada = LocalDate.parse(dto.getDataEntrada());
        LocalDate saida = LocalDate.parse(dto.getDataSaida());

        long dias = ChronoUnit.DAYS.between(entrada, saida) + 1;
        if (dias <= 0) {
            throw new RuntimeException("Data de saída deve ser posterior à data de entrada.");
        }

        double valorTotal = quarto.getPrecoPorNoite() * dias;

        Reserva reserva = new Reserva();
        reserva.setCliente(cliente);
        reserva.setQuarto(quarto);
        reserva.setDataEntrada(entrada);
        reserva.setDataSaida(saida);
        reserva.setValorTotal(valorTotal);

        return service.salvar(reserva);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        service.deletar(id);
    }
}
