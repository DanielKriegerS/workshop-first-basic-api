package com.danielks.ProductAPI.services;

import com.danielks.ProductAPI.entities.Product;
import com.danielks.ProductAPI.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> getAll() {
        return repository.findAll().stream().toList();
    }

    public Product geById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product with id "+ id +" not found"));
    }

    public UUID createProduct(Product product) {
        product.validate();
        Product savedProduct = repository.save(product);
        return savedProduct.getId();
    }

    public Product updateProduct(Product product, UUID id) {
        Product oldProduct = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product with id "+ id +" not found"));

        oldProduct.setName(product.getName());
        oldProduct.setProductValue(product.getProductValue());
        return repository.save(oldProduct);
    }

    public void deleteProduct(UUID id) {
        repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product with id "+ id +" not found"));

        repository.deleteById(id);
    }
}
