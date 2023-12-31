package com.example.programming.productservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.programming.productservice.dto.ProductRequest;
import com.example.programming.productservice.dto.ProductResponse;
import com.example.programming.productservice.service.ProductService;

import java.util.List;

import org.springframework.http.HttpStatus;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {
	  private final ProductService productService;

	    @PostMapping
	    @ResponseStatus(HttpStatus.CREATED)
	    public void createProduct(@RequestBody ProductRequest productRequest) {
	        productService.createProduct(productRequest);
	    }

	    @GetMapping
	    @ResponseStatus(HttpStatus.OK)
	    public List<ProductResponse> getAllProducts() {
	        return productService.getAllProducts();
	    }
}
