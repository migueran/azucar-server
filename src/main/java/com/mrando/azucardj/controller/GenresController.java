package com.mrando.azucardj.controller;

import org.springframework.ui.Model;

import java.util.List;

import com.mrando.azucardj.model.Genre;
import com.mrando.azucardj.service.GenresServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/genres")
public class GenresController {

    @Autowired
    private GenresServices genresServices;

    @GetMapping
    public List<Genre> fetch() {
        return genresServices.fetch();
    }

    @PostMapping
    public void save(@RequestBody Genre genre) {
        genresServices.save(genre);
    }

    @GetMapping("/{idGenre}")
    public Genre getById(@PathVariable Integer idGenre, Model model) {
        model.addAttribute("idGenre", idGenre);
        return genresServices.findById(idGenre);
    }

    @GetMapping("/name/{name}")
    public Genre getByNane(@PathVariable String name, Model model) {
        model.addAttribute("name", name);
        return genresServices.findByName(name);
    }

    @PutMapping("/{id}")
    public Genre update(@PathVariable Integer id, @RequestBody Genre genre) {
        return genresServices.update(id, genre);
    }

    @DeleteMapping("/{idGenre}")
    public void delete(@PathVariable Integer idGenre) {
        genresServices.delete(idGenre);
    }
}