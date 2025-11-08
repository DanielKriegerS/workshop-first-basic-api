package com.danielks.ProductAPI.services;

import com.danielks.ProductAPI.entities.Product;
import com.danielks.ProductAPI.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> getAll() {
        return repository.findAll().stream().toList();
    }
}
