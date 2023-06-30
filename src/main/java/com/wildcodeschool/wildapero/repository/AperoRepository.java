package com.wildcodeschool.wildapero.repository;

import com.wildcodeschool.wildapero.entity.Apero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AperoRepository extends JpaRepository<Apero, Long> {

    // comment ajouter des requêtes personnalisées ?
}
