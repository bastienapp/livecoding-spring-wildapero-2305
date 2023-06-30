package com.wildcodeschool.wildapero.repository;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CrudDAO<T, U> {

    List<T> findAll();

    Optional<T> findById(U id);

    T save(T element);

    void deleteById(U id);
}
