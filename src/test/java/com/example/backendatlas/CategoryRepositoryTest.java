package com.example.backendatlas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import com.example.backendatlas.entity.Category;
import java.util.Optional;

import com.example.backendatlas.repository.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@ExtendWith(MockitoExtension.class)
public class CategoryRepositoryTest {

    @Mock
    private CategoryRepository categoryRepository;

    @Test
    public void testFindById() {
        // Opret en mock Category instans
        Category category = new Category();
        category.setId(1);

        // Opsæt mock adfærd for 'findById' metoden
        when(categoryRepository.findById(1L)).thenReturn(Optional.of(category));

        // Udfør testen
        Optional<Category> result = categoryRepository.findById(1L);

        // Bekræft resultatet
        assertTrue(result.isPresent());
        assertEquals(1, result.get().getId());
    }

}



