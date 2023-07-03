package com.wildcodeschool.wildapero.entity;


import jakarta.persistence.*;

// Java Bean : serializable, constructeur vide, attribus privées, getters/setters
@Entity
// PacalCase : nom de l'entité côté java, snake_case : nom de la table
@Table(name="apero")
public class Apero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // TODO :rechercher pourquoi "nullable = false et valeur par défaut" ça marche pas !
    @Column(length = 50)
    private String name;

    // TODO: recherche @Temporal et format de date

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
}
