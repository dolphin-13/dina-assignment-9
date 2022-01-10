package com.coderscampus.dinaassignment9.service;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import org.springframework.stereotype.Service;

import com.coderscampus.dinaassignment9.domain.Recipe;

@Service
public class FileService {

	public List<Recipe> storeAllRecipes() throws IOException {
		Reader in = new FileReader("recipes.txt");
		List<Recipe> recipes = new ArrayList<>();
		
		Iterable<CSVRecord> records = CSVFormat.DEFAULT.withEscape('\\').withFirstRecordAsHeader()
				.withIgnoreSurroundingSpaces().parse(in);
		for (CSVRecord record : records) {
			Integer cookingMinutes = Integer.parseInt(record.get(0));
			boolean dairyFree = Boolean.parseBoolean(record.get(1));
			boolean glutenFree = Boolean.parseBoolean(record.get(2));
			String instructions = record.get(3);
			Double prepMin = Double.parseDouble(record.get(4));
			Double price = Double.parseDouble(record.get(5));
			Integer readyInMin = Integer.parseInt(record.get(6));
			Integer servings = Integer.parseInt(record.get(7));
			Double score = Double.parseDouble(record.get(8));
			String title = record.get(9);
			Boolean vegan = Boolean.parseBoolean(record.get(10));
			Boolean vegetarian = Boolean.parseBoolean(record.get(11));

			Recipe recipe = new Recipe();

			recipe.setCookingMinutes(cookingMinutes);
			recipe.setDairyFree(dairyFree);
			recipe.setGlutenFree(glutenFree);
			recipe.setInstructions(instructions);
			recipe.setPreparationMinutes(prepMin);
			recipe.setPricePerServing(price);
			recipe.setReadyInMinutes(readyInMin);
			recipe.setServings(servings);
			recipe.setSpoonacularScore(score);
			recipe.setTitle(title);
			recipe.setVegan(vegan);
			recipe.setVegetarian(vegetarian);

			recipes.add(recipe);
		}

		return recipes;

	}

}
