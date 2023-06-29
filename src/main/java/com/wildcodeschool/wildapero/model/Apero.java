package com.wildcodeschool.wildapero.model;

import java.util.List;

// Java Bean : serializable, constructeur vide, attribus privées, getters/setters
public class Apero {

    private Long id;

    private String name;

    private List<String> ingredients;

    public Apero() {}

    public Apero(Long id, String name, List<String> ingredients) {
        this.id = id;
        this.name = name;
        this.ingredients = ingredients;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }
}
