package com.example.demoH2.service;


import org.springframework.stereotype.Service;
import com.example.demoH2.dao.IngredientDAO;
import com.example.demoH2.dto.IngredientDTO;
import com.example.demoH2.mapper.IngredientMapper;

import java.util.ArrayList;
import java.util.List;
import com.example.demoH2.model.Ingredient;

@Service
public class IngredientService {
	private IngredientDAO ingredientDAO;
	private IngredientMapper ingredientMapper;
	
	public IngredientService(IngredientDAO ingredientDAO,IngredientMapper ingredient) {
		this.ingredientDAO=ingredientDAO;
		this.ingredientMapper=ingredient;
	}
	
	public List<IngredientDTO> getIngredientsAll(){
		
		List<IngredientDTO> listeDTO = new ArrayList<>();
		for(Ingredient ing:ingredientDAO.getAllIngredients()) {
			listeDTO.add(ingredientMapper.ingredientToIngredientDTO(ing));
		}
		return listeDTO;
	}

	public IngredientDTO getByIdIngredient(Long id){
		return ingredientMapper.ingredientToIngredientDTO(ingredientDAO.getIngredientById(id));
	}
	
	public void updateMyIngredient(IngredientDTO ingredientdto){
		 ingredientDAO.updateIngredient(ingredientMapper.ingredientDTOtoIngredient(ingredientdto));
	}
	
	public int deleteMyIngredient(Long id){
		return ingredientDAO.deleteIngredientById(id);
	}
	
	public int deleteAllIngredients(){
		return ingredientDAO.deleteIngredients();
	}
	
	public void createAnIngredient(IngredientDTO ingredient){
		ingredientDAO.createIngredient(ingredientMapper.ingredientDTOtoIngredient(ingredient));
	}
	
}
