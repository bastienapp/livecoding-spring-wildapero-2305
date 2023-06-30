package com.wildcodeschool.wildapero.entity;

import jakarta.persistence.*;

// Java Bean : serializable, constructeur vide, attribus privées, getters/setters
@Entity
public class Apero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String name;

    // private List<String> ingredients;

    public Apero() {}

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

    /*
    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }*/
}
