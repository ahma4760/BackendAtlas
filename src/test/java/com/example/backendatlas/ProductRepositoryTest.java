package com.example.backendatlas;

import com.example.backendatlas.entity.Category;
import com.example.backendatlas.entity.Product;
import com.example.backendatlas.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class ProductRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void testFindAllByCategory_Id() {
        // Opsæt data
        Category category = new Category();
        category.setId(1);
        entityManager.persist(category);

        Product product = new Product();

        entityManager.persist(product);
        entityManager.flush();

        // Test
        List<Product> products = productRepository.findAllByCategory_Id(1);
        assertFalse(products.isEmpty());
        // Andre assertions kan tilføjes for at validere den korrekte funktionalitet
    }
}

