package com.wildcodeschool.wildapero.entity;


import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;

// Java Bean : serializable, constructeur vide, attribus privées, getters/setters
@Entity
// PacalCase : nom de l'entité côté java, snake_case : nom de la table
@Table(name="apero")
public class Apero {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    // TODO :rechercher pourquoi "nullable = false et valeur par défaut" ça marche pas !
    @Column(length = 50)
    private String name;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(columnDefinition = "TIMESTAMP")
    java.sql.Timestamp createdAt;

    // TODO: recherche @Temporal et format de date

    public Apero() {}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
