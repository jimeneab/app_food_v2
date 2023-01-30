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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.app.entity.Ingredient;
import com.example.app.repository.IIngredientRepository;

import jakarta.validation.Valid;

@RestController
public class IngredientController {

    @Autowired
    IIngredientRepository ingredientRepository;

    @GetMapping("/ingredients")
    public ResponseEntity<List<Ingredient>> getIngredients() {
        try {
            List<Ingredient> ingredients = ingredientRepository.findAll();
            return new ResponseEntity<>(ingredients, HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/admin/ingredients")
    public ResponseEntity<Ingredient> createIngredient(@Valid @RequestBody Ingredient newIngredient) {
        try {
            ingredientRepository.save(newIngredient);
            return new ResponseEntity<>(newIngredient, HttpStatus.CREATED);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED);
        }
    }

    @GetMapping("/ingredients/{id}")
    public ResponseEntity<Ingredient> getIngredient(@Valid @PathVariable("id") long id) {
        try {
            Optional<Ingredient> ingredient = ingredientRepository.findById(id);
            return new ResponseEntity<>(ingredient.get(), HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/admin/ingredients/{id}")
    public ResponseEntity<HttpStatus> deleteIngredient(@Valid @PathVariable("id") long id) {
        try {
            ingredientRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/admin/ingredients/{id}")
    public ResponseEntity<Ingredient> updateIngredient(@Valid @PathVariable("id") long id,
            @Valid @RequestBody Ingredient updatedIngredient) {
        try {
            Optional<Ingredient> currentIngredient = ingredientRepository.findById(id);
            if (currentIngredient.isPresent()) {
                Ingredient _ingredient = currentIngredient.get();
                _ingredient.setName(updatedIngredient.getName());
                _ingredient.setCarbs(updatedIngredient.getCarbs());
                _ingredient.setEnergy(updatedIngredient.getEnergy());
                _ingredient.setFat(updatedIngredient.getFat());
                _ingredient.setProteins(updatedIngredient.getProteins());
                _ingredient.setQuantity(updatedIngredient.getQuantity());
                return new ResponseEntity<>(ingredientRepository.save(_ingredient), HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_MODIFIED);
        }
    }

}
