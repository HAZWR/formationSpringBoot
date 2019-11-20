package com.example.demoH2.mapper;

import org.springframework.stereotype.Component;

import com.example.demoH2.dto.IngredientDTO;
import com.example.demoH2.model.Ingredient;

@Component
public class IngredientMapper {

	public Ingredient ingredientDTOtoIngredient(IngredientDTO ingredientDTO) {
		return new Ingredient(ingredientDTO.getId(),ingredientDTO.getName());
	}
	
	public IngredientDTO ingredientToIngredientDTO(Ingredient ingredient){
		return new IngredientDTO(ingredient.getId(),ingredient.getName());
	}
}
