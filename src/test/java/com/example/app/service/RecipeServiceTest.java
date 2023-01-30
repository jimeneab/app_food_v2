package com.example.app.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.given;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import com.example.app.entity.Recipe;
import com.example.app.repository.IRecipeRepository;

@ExtendWith(MockitoExtension.class)
public class RecipeServiceTest {

    @Mock
    private IRecipeRepository recipeRepository;

    @InjectMocks
    private RecipeService recipeService;

    private Recipe recipe;

    @BeforeEach
    void setup() {
        recipe = Recipe.builder().name("Recipe tes2 1").id(1L).build();
    }

    @DisplayName("save recipe")
    @Test
    void testSaveRecipe() {
        given(recipeRepository.findByName(recipe.getName())).willReturn(Optional.empty());
        given(recipeRepository.save(recipe)).willReturn(recipe);

        Recipe savedRecipe = recipeService.saveRecipe(recipe);

        assertThat(savedRecipe).isNotNull();
    }

}
