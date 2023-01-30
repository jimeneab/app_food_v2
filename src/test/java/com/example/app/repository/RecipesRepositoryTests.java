package com.example.app.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.app.entity.Recipe;

@DataJpaTest
public class RecipesRepositoryTests {

    @Autowired
    private IRecipeRepository recipeRepository;

    private Recipe recipe;

    @BeforeEach
    void setup() {
        recipe = Recipe.builder().id(1L).name("Recipe tes2 1").build();
        System.out.println(recipe);
    }

    @Test
    @DisplayName("Save recipe")
    void testSaveRecipe() {

        Recipe savedRecipe = recipeRepository.save(recipe);

        assertThat(savedRecipe).isNotNull();
        assertThat(savedRecipe.getId()).isGreaterThan(0);
    }

    @Test
    @DisplayName("get all recipes test")
    void testGetAllREcipes() {
        Recipe recipe2 = Recipe.builder().id(2L).name("Recipe test 2").build();

        recipeRepository.save(recipe2);
        recipeRepository.save(recipe);

        List<Recipe> allRecipes = recipeRepository.findAll();

        assertThat(allRecipes).isNotNull();
        assertThat(allRecipes.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("get recipe by id")
    void testGetRecipeById() {
        recipeRepository.save(recipe);

        Recipe recipeBD = recipeRepository.findById(recipe.getId()).get();

        assertThat(recipeBD).isNotNull();
    }

    @Test
    @DisplayName("delete recipe")
    void testDeleteRecipe() {
        recipeRepository.save(recipe);

        recipeRepository.deleteById(recipe.getId());
        Optional<Recipe> recipeOptional = recipeRepository.findById(recipe.getId());

        assertThat(recipeOptional).isEmpty();
    }

};
