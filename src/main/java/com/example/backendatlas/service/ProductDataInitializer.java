package com.example.backendatlas.service;

import com.example.backendatlas.entity.Product;
import com.example.backendatlas.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ProductDataInitializer implements CommandLineRunner {

    private final ProductRepository productRepository;

    @Autowired
    public ProductDataInitializer(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Product product1 = new Product(
                1,
                "Hawaii",
                "Skinke, ost, ananas",
                "https://mambeno.dk/wp-content/uploads/2016/06/Mambenos-hawaiipizza.jpg",
                58.0
        );
        Product product2 = new Product(
                2,
                "Margherita",
                "Ost, tomat",
                "https://img.mummum.dk/wp-content/uploads/2020/05/P1160057-860x755.jpg",
                40.0
        );

        productRepository.save(product1);
        productRepository.save(product2);
    }
}
