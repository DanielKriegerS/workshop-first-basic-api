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
    private UUID id;
    private String name;
    private Double productValue;

    public Product() {
    }

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

    public void setName(String name) {
        this.name = name;
    }

    public void setProductValue(Double productValue) {
        this.productValue = productValue;
    }

}
