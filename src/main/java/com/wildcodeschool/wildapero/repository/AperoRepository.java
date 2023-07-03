package com.wildcodeschool.wildapero.repository;

import com.wildcodeschool.wildapero.entity.Apero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AperoRepository extends JpaRepository<Apero, Long> {

    // comment ajouter des requêtes personnalisées ?
    // 1 : query methods
    Optional<Apero> findAperoByName(String name);

    List<Apero> findAperosByNameContaining(String name);

    // 2 : l'annotation @Query et utilisation du JPQL
    // utile pour des requêtes avec des jointures
    @Query("SELECT aperoItem FROM Apero aperoItem WHERE aperoItem.name = :nameValue")
    Optional<Apero> getAperoByNameJPQL(String nameValue);
}
