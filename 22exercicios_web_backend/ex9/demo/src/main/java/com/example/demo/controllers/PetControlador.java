package com.example.demo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Pet;
import com.example.demo.services.PetService;

@RestController
@RequestMapping("/pets")
public class PetControlador {
		
	private PetService petService;

	public PetControlador(PetService petService) {
		this.petService = petService;
	}
	
	@GetMapping
	public List<Pet> buscarPets() {
		return petService.obterPets();
	}
	
	@PostMapping
	public Pet cadastrarPet(@RequestBody Pet pet) {
		return petService.cadastrarPet(pet);
	}
	
	@DeleteMapping("/{id}")
	public String excluirPet(@PathVariable Integer id) {
		return petService.excluirPet(id);
	}
	
}