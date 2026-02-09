package com.mrando.azucardj.controller;

import java.util.List;

import com.mrando.azucardj.model.Genre;
import com.mrando.azucardj.service.GenresServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/genres")
public class GenresController {

    @Autowired
    private GenresServices genresServices;

    @GetMapping
    public List<Genre> fetchGenres() {
        return genresServices.fetch();
    }

    @PostMapping
    public void saveGenre(@RequestBody String genre) {
        genresServices.save(genre);
    }

    @GetMapping("/{id}")
    public Genre getGenreById(@PathVariable Integer id) {
        return genresServices.searchById(id);
    }
}