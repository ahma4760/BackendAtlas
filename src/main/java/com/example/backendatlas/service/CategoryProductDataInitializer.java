package com.example.backendatlas.service;

import com.example.backendatlas.entity.Category;
import com.example.backendatlas.entity.Product;
import com.example.backendatlas.repository.CategoryRepository;
import com.example.backendatlas.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CategoryProductDataInitializer implements CommandLineRunner {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryProductDataInitializer(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Category category1 = new Category(
                1,
                "Pizza"
        );
        Category category2 = new Category(
                2,
                "Drinks"
        );
        Product product1 = new Product(
                1,
                "Hawaii",
                "Skinke, ost, ananas",
                "https://mambeno.dk/wp-content/uploads/2016/06/Mambenos-hawaiipizza.jpg",
                58.0,
                category1
        );
        Product product2 = new Product(
                2,
                "Margherita",
                "Ost, tomat",
                "https://img.mummum.dk/wp-content/uploads/2020/05/P1160057-860x755.jpg",
                40.0,
                category1
        );
        Product product3 = new Product(
                3,
                "Coca-Cola",
                null,
                "https://sushiya.dk/wp-content/uploads/2022/07/cocacola-can.jpg",
                12.0,
                category2
        );
        Product product4 = new Product(
                4,
                "Pepsi",
                null,
                "https://sushiya.dk/wp-content/uploads/2022/07/cocacola-can.jpg",
                12.0,
                category2
        );

        categoryRepository.save(category1);
        categoryRepository.save(category2);
        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);
        productRepository.save(product4);
    }
}
