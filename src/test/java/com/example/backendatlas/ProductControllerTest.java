package com.example.backendatlas;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import com.example.backendatlas.api.ProductController;
import com.example.backendatlas.entity.Product;
import com.example.backendatlas.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

@WebMvcTest(ProductController.class)
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductRepository productRepository;

    @Test
    public void testGetAllProducts() throws Exception {
        Product product = new Product(); // Erstat med rigtig Product-klasse
        // Sæt product-felter

        List<Product> allProducts = Arrays.asList(product);
        when(productRepository.findAll()).thenReturn(allProducts);

        mockMvc.perform(get("/products").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0]").exists()); // Tilføj flere expect, som matcher din output
    }

    @Test
    public void testGetProductsByCategoryId() throws Exception {
        int catId = 1; // Eksempel category ID
        Product product = new Product(); // Erstat med rigtig Product-klasse
        // Sæt product-felter

        List<Product> products = Arrays.asList(product);
        when(productRepository.findAllByCategory_Id(catId)).thenReturn(products);

        mockMvc.perform(get("/products/" + catId).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0]").exists()); // Tilføj flere expect, som matcher din output
    }
}

