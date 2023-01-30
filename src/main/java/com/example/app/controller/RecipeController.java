package com.example.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.app.entity.Recipe;
import com.example.app.service.RecipeService;

import jakarta.validation.Valid;

@RestController
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @GetMapping("/recipes")
    public ResponseEntity<List<Recipe>> getRecipes() {
        try {
            List<Recipe> recipes = recipeService.getAllRecipes();
            return new ResponseEntity<>(recipes, HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/admin/recipes")
    public ResponseEntity<Recipe> createRecipe(@Valid @RequestBody Recipe newRecipe) {
        try {
            recipeService.saveRecipe(newRecipe);
            return new ResponseEntity<>(newRecipe, HttpStatus.CREATED);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED);
        }
    }

    @DeleteMapping("/admin/recipes/{id}")
    public ResponseEntity<String> deleteRecipe(@Valid @PathVariable("id") long id) {
        try {
            recipeService.deleteRecipe(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/recipes/{id}")
    public ResponseEntity<Recipe> getRecipe(@Valid @PathVariable("id") long id) {
        try {
            Optional<Recipe> recipe = recipeService.getRecipeById(id);
            return new ResponseEntity<>(recipe.get(), HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

}
