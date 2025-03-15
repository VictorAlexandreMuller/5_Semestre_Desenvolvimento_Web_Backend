package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.models.Pet;

@Service
public class PetService {
	
	private List<Pet> pets = new ArrayList<Pet>();
	
	public List<Pet> obterPets() {
		return pets;
	}
	
	public Pet cadastrarPet(Pet pet) {
		Pet novoPet = new Pet(pets.size() + 1, pet.getNome(), pet.getRaca(), pet.getCor(), pet.getPeso(), pet.getTamanho());
	
		pets.add(novoPet);
		
		return pets.getLast();
	}
	
	public String excluirPet(Integer id) {
		Pet buscarPet = null;
		
		for (int i = 0; i < pets.size(); i++) {
			if (pets.get(i).getId() == id) {
				buscarPet = pets.get(i);
				pets.remove(i);
				break;
			}
			
		}
		
		if (buscarPet != null) {
			return "Pet excluído.";
		} 
		
		return "Não foi possível identificar o Pet.";
	}
	
}
