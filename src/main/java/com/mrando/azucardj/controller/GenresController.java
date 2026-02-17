package com.mrando.azucardj.controller;

import org.springframework.ui.Model;

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
    public void saveGenre(@RequestBody Genre genre) {
        genresServices.save(genre);
    }

    @GetMapping("/{idGenre}")
    public Genre getGenreById(@PathVariable Integer idGenre, Model model) {
        model.addAttribute("idGenre", idGenre);
        return genresServices.searchById(idGenre);
    }

    @GetMapping("/name/{name}")
    public Genre getGenreByNane(@PathVariable String name, Model model) {
        model.addAttribute("name", name);
        return genresServices.searchByName(name);
    }

    @DeleteMapping("/{idGenre}")
    public void deleteGenreById(@PathVariable Integer idGenre) {
        genresServices.deleteById(idGenre);
    }
}