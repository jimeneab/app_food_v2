package com.example.app.service;

import java.util.List;
import java.util.Optional;

import com.example.app.entity.Recipe;

public interface RecipeService {

    Recipe saveRecipe(Recipe newRecipe);

    List<Recipe> getAllRecipes();

    Optional<Recipe> getRecipeById(long id);

    void deleteRecipe(long id);
}
