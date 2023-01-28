package com.example.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.app.entity.Recipe;

public interface IRecipeRepository extends CrudRepository<Recipe, Long> {
    List<Recipe> findAll();

    Recipe findById(long id);
}
