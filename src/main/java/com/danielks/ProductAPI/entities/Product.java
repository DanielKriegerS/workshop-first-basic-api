package com.danielks.ProductAPI.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private final UUID id;
    private final String name;
    private final Double productValue;

    public Product(UUID id, String name, Double productValue) {
        this.id = id;
        this.name = name;
        this.productValue = productValue;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getProductValue() {
        return productValue;
    }
}
