package com.coderscampus.dinaassignment9.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.coderscampus.dinaassignment9.domain.Recipe;

@Service
public class RecipeService {

	private List<Recipe> recipes = new ArrayList<>();
	private FileService fservice = new FileService();

	public List<Recipe> getAllRecipes() {
		if (CollectionUtils.isEmpty(recipes)) {
			try {
				recipes = fservice.storeAllRecipes();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		return recipes;
	}

	public List<Recipe> getVegetarian() {
		                return getAllRecipes().stream()
				                              .filter(recipe -> recipe.getVegetarian()) // equals(true) is inside already
				                              .collect(Collectors.toList());
	}

	public List<Recipe> getVegan() {
		                return getAllRecipes().stream()
				                              .filter(recipe -> recipe.getVegan())
				                              .collect(Collectors.toList());
	}

	public List<Recipe> getGlutenFree() {
		                return getAllRecipes().stream()
				                              .filter(recipe -> recipe.getGlutenFree())
				                              .collect(Collectors.toList());
	}

	public List<Recipe> getVeganAndGlutenFree() {
		                return getAllRecipes().stream()
				                              .filter(recipe -> recipe.getGlutenFree() && recipe.getVegan())
				                              .collect(Collectors.toList());
	}

}
