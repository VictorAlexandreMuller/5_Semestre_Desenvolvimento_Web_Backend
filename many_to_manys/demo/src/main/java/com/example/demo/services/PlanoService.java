package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Plano;
import com.example.demo.repositories.PlanoRepository;

@Service
public class PlanoService {

    @Autowired
    private PlanoRepository planoRepository;

    public List<Plano> listarTodos() {
        return planoRepository.findAll();
    }

    public Plano buscarPorId(Long id) {
        return planoRepository.findById(id).orElseThrow(() -> 
            new RuntimeException("Plano com ID " + id + " não encontrado."));
    }

    public Plano salvar(Plano plano) {
        return planoRepository.save(plano);
    }

    public void deletar(Long id) {
        if (!planoRepository.existsById(id)) {
            throw new RuntimeException("Plano com ID " + id + " não encontrado.");
        }
        planoRepository.deleteById(id);
    }    

    public Plano atualizar(Long id, Plano planoAtualizado) {
        Plano plano = planoRepository.findById(id).orElseThrow(() -> 
            new RuntimeException("Plano com ID " + id + " não encontrado."));
        
        plano.setTipo(planoAtualizado.getTipo());
        
        return planoRepository.save(plano);
    }
    
}
