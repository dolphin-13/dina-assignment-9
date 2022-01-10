package com.coderscampus.dinaassignment9.web;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderscampus.dinaassignment9.domain.Recipe;
import com.coderscampus.dinaassignment9.service.FileService;

//Controllers listen to web created stuff, 
//GetMapping is used as a part of a Controller, it listens for requests coming in 
//and when it receives the request, it redirects it to right path
//GetMapping listens to GET requests and listen them on certain path

@RestController // returns raw data, whereas Controller returns web page
public class RecipeController {

	@Autowired
	private FileService fileService;

	@GetMapping("/gluten-free")
	public List<Recipe> glutenFree() throws IOException {
		return fileService.storeAllRecipes()
				          .stream()
				          .filter(recipe -> recipe.getGlutenFree().equals(true))
				          .collect(Collectors.toList());
	}

	@GetMapping("/vegan")
	public List<Recipe> vegan() throws IOException {
		return fileService.storeAllRecipes()
				          .stream()
				          .filter(recipe -> recipe.getVegan().equals(true))
				          .collect(Collectors.toList());
	}

	@GetMapping("/vegan-and-gluten-free")
	public List<Recipe> veganAndGlutenFree() throws IOException {
		return fileService.storeAllRecipes()
				          .stream()
				          .filter(recipe -> recipe.getGlutenFree() && recipe.getVegan().equals(true))
				          .collect(Collectors.toList());
	}

	@GetMapping("/vegetarian")
	public List<Recipe> vegetarian() throws IOException {
		return fileService.storeAllRecipes()
				          .stream().filter(recipe -> recipe.getVegetarian().equals(true))
				          .collect(Collectors.toList());
	}

	@GetMapping("/all-recipes")
	public List<Recipe> allRecipes() throws IOException {
		return fileService.storeAllRecipes();
	}

}
