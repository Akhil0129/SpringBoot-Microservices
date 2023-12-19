package com.example.programming.productservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.programming.productservice.model.Product;

public interface ProductRepository extends MongoRepository<Product, String> {
}
