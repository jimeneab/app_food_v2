package com.example.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
@Table(name = "ingredient")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @NotBlank
    @Column(name = "energy", nullable = false, length = 5)
    private int energy;

    @NotBlank
    @Column(name = "fat", nullable = false, length = 5)
    private int fat;

    @NotBlank
    @Column(name = "carbs", nullable = false, length = 5)
    private int carbs;

    @NotBlank
    @Column(name = "proteins", nullable = false, length = 5)
    private int proteins;

    @NotBlank
    @Column(name = "quantity", nullable = false, length = 5)
    private int quantity;
}
