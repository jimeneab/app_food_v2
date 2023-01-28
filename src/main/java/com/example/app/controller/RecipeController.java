package com.example.app.controller;

import java.util.List;

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
import com.example.app.repository.IRecipeRepository;

@RestController
public class RecipeController {

    @Autowired
    IRecipeRepository recipeRepository;

    @GetMapping("/recipes")
    public ResponseEntity<List<Recipe>> getRecipes() {
        try {
            List<Recipe> recipes = recipeRepository.findAll();
            return new ResponseEntity<>(recipes, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/recipes")
    public ResponseEntity<Recipe> createRecipe(@RequestBody Recipe newRecipe) {
        try {
            recipeRepository.save(newRecipe);
            return new ResponseEntity<>(newRecipe, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/recipes/{id}")
    public ResponseEntity<HttpStatus> deleteRecipe(@PathVariable("id") long id) {
        try {
            recipeRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseStatusException(400)
        }
    }

    @GetMapping("/recipes/{id}")
    public ResponseEntity<Recipe> getRecipe(@PathVariable("id") long id) {
        try {
            Recipe recipe = recipeRepository.findById(id);
            return new ResponseEntity<>(recipe, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
