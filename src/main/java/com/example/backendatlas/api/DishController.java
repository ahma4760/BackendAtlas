package com.example.backendatlas.api;

import com.example.backendatlas.entity.Dish;
import com.example.backendatlas.repository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DishController {
    private final DishRepository dishRepository;

    @Autowired
    public DishController(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    @GetMapping("/dishes")
    public ResponseEntity<List<Dish>> getAllDishes() {
        List<Dish> dishes = dishRepository.findAll();
        return new ResponseEntity<>(dishes, HttpStatus.OK);
    }
}
