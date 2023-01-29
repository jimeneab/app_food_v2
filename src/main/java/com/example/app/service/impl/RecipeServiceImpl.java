package com.example.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.entity.Recipe;
import com.example.app.exception.ResourceNotFoundException;
import com.example.app.repository.IRecipeRepository;
import com.example.app.service.RecipeService;

@Service
public class RecipeServiceImpl implements RecipeService {

    @Autowired
    private IRecipeRepository recipeRepository;

    @Override
    public Recipe saveRecipe(Recipe newRecipe) {
        Optional<Recipe> savedRecipe = recipeRepository.findByName(newRecipe.getName());
        if (savedRecipe.isPresent()) {
            throw new ResourceNotFoundException("the recipe is already exist");
        }
        return recipeRepository.save(newRecipe);
    }

    @Override
    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    @Override
    public Optional<Recipe> getRecipeById(long id) {
        return recipeRepository.findById(id);
    }

    @Override
    public void deleteRecipe(long id) {
        recipeRepository.deleteById(id);
    }

}
