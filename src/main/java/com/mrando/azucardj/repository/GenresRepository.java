package com.mrando.azucardj.repository;

import org.springframework.data.repository.CrudRepository;

import com.mrando.azucardj.model.Genre;

public interface GenresRepository extends CrudRepository<Genre, Integer> {

}
