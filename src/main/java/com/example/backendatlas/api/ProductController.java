package com.example.backendatlas.api;

import com.example.backendatlas.entity.Product;
import com.example.backendatlas.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class ProductController {
    private final ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/products/{catId}")
    public ResponseEntity<List<Product>> getProductsByCategoryId(@PathVariable("catId") int catId) {
        List<Product> products = productRepository.findAllByCategory_Id(catId);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
