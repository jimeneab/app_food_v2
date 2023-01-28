package com.example.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.app.entity.Ingredient;

public interface IIngredientRepository extends JpaRepository<Ingredient, Long> {
}
