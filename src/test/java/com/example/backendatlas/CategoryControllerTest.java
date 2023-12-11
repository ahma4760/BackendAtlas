package com.example.backendatlas;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import com.example.backendatlas.api.CategoryController;
import com.example.backendatlas.entity.Category;
import com.example.backendatlas.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

@WebMvcTest(CategoryController.class)
public class CategoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CategoryRepository categoryRepository;

    @Test
    public void getCategoriesTest() throws Exception {
        // Opret mock-data
        Category category = new Category();
        category.setName("Test Category"); // Tilpas efter din Category-klasse
        List<Category> allCategories = Arrays.asList(category);

        // Konfigurér mock adfærd
        when(categoryRepository.findAll()).thenReturn(allCategories);

        // Udfør og verificer anmodningen
        mockMvc.perform(get("/categories").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Test Category")); // Tilpas JSONPath og værdier efter din datastruktur
    }
}

