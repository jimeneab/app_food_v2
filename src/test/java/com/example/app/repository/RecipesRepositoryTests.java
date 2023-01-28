package com.example.app.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.app.entity.Recipe;

@DataJpaTest
public class RecipesRepositoryTests {

    @Autowired
    private IRecipeRepository recipeRepository;

    @Test
    @DisplayName("Save recipe")
    void testSaveRecipe() {
        Recipe recipe_1 = new Recipe("Recipe 1 test");

        Recipe savedRecipe = recipeRepository.save(recipe_1);

        assertThat(savedRecipe).isNotNull();
        assertThat(savedRecipe.getId()).isGreaterThan(0);
    }

}
