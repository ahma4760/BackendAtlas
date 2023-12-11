package com.example.backendatlas;

import static org.mockito.Mockito.*;

import com.example.backendatlas.entity.Category;
import com.example.backendatlas.entity.Product;
import com.example.backendatlas.repository.CategoryRepository;
import com.example.backendatlas.repository.ProductRepository;
import com.example.backendatlas.service.CategoryProductDataInitializer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class CategoryProductDataInitializerTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryProductDataInitializer dataInitializer;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void run_shouldInitializeData() throws Exception {
        // Kald run-metoden
        dataInitializer.run();

        // Verificer, at categoryRepository.save blev kaldt med de rigtige kategorier
        verify(categoryRepository).save(any(Category.class));
        // Tilføj flere verifikationer for specifikke kategorier, hvis nødvendigt

        // Verificer, at productRepository.save blev kaldt med de rigtige produkter
        verify(productRepository).save(any(Product.class));
        // Tilføj flere verifikationer for specifikke produkter, hvis nødvendigt
    }
}

