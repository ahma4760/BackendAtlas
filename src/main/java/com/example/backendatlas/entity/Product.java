package com.example.backendatlas.entity;

import jakarta.persistence.*;

@Entity
@Table(name="dishes")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String ingredients;
    private String imagePath;
    private double price;

    public Product() {
    }

    public Product(int id, String title, String ingredients, String imagePath, double price) {
        this.id = id;
        this.title = title;
        this.ingredients = ingredients;
        this.imagePath = imagePath;
        this.price = price;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
