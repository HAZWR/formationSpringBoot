package com.example.demoH2.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoH2.dto.IngredientDTO;
import com.example.demoH2.model.Ingredient;
import com.example.demoH2.service.IngredientService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value="Ingredient API", description="Operations for managing an ingredient")
@RestController
@RequestMapping("/api/v1/ingredients")
public class IngredientController {

	private IngredientService ingredientService;
	
	public IngredientController(IngredientService ingredientService) {
		this.ingredientService=ingredientService;
	}
	 
	@ApiOperation(value = "View a list of all ingredients", response = List.class)
	@GetMapping
	public List<IngredientDTO> listIngredient(){
		 	return ingredientService.getIngredientsAll();
	 }
	

	@ApiOperation(value = "View an ingredient by id", response = IngredientDTO.class)
	@GetMapping("/{id}")
	public IngredientDTO getByIdIngredientURL(Long id) {
		return ingredientService.getByIdIngredient(id);		
	}
	
	@ApiOperation(value = "Create a new ingredient", response = IngredientDTO.class)
	@PostMapping
	public void createIngredient(@ApiParam(value = "Employee object store in database table", required = true) @Valid @RequestBody IngredientDTO ingredient) {		
		ingredientService.createAnIngredient(ingredient);
	}
	
	@ApiOperation(value = "Delete ingredient", response = IngredientDTO.class)
	@DeleteMapping("/{id}")
	public void deleteIngredient(@ApiParam(value = "Ingredient id from which ingredient object will retrieve", required = true)@PathVariable(value="id")Long id) {
		ingredientService.deleteMyIngredient(id);
	}
	
	@ApiOperation(value = "Update ingredient", response = IngredientDTO.class)
	@PutMapping
	public void updateIngredient(@ApiParam(value = "Employee object store in database table", required = true) @Valid @RequestBody IngredientDTO ingredient) {
		 ingredientService.updateMyIngredient(ingredient);	
	}
}
