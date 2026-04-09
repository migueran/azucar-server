package com.mrando.azucardj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mrando.azucardj.model.Genre;

@Repository
public interface GenresRepository extends JpaRepository<Genre, Integer> {
    Genre findByName(String name);
}