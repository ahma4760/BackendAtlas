package com.example.backendatlas.service;

import com.example.backendatlas.entity.Dish;
import com.example.backendatlas.repository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DishDataInitializer implements CommandLineRunner {

    private final DishRepository dishRepository;

    @Autowired
    public DishDataInitializer(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Dish dish1 = new Dish(
                1,
                "Hawaii",
                "Skinke, ost, ananas",
                "https://mambeno.dk/wp-content/uploads/2016/06/Mambenos-hawaiipizza.jpg",
                58.0
        );
        Dish dish2 = new Dish(
                2,
                "Margherita",
                "Ost, tomat",
                "https://img.mummum.dk/wp-content/uploads/2020/05/P1160057-860x755.jpg",
                40.0
        );

        dishRepository.save(dish1);
        dishRepository.save(dish2);
    }
}
