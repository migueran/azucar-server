package com.mrando.azucardj.controller;

import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;

import com.mrando.azucardj.model.Artist;
import com.mrando.azucardj.service.ArtistsServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/artists")
public class ArtistsController {

    @Autowired
    private ArtistsServices artistsServices;

    @GetMapping
    public List<Artist> fetch() {
        return artistsServices.fetch();
    }

    @PostMapping
    public void save(@RequestBody Artist artist) {
        artistsServices.save(artist);
    }

    @GetMapping("/{id}")
    public Optional<Artist> getById(@PathVariable Integer id, Model model) {
        model.addAttribute("id", id);
        return artistsServices.findById(id);
    }

    @GetMapping("/name/{name}")
    public Optional<Artist> getByName(@PathVariable String name, Model model) {
        model.addAttribute("name", name);
        return artistsServices.findByName(name);
    }

    @GetMapping("/genero/{idGenre}")
    public List<Artist> getByGenre(@PathVariable Integer idGenre, Model model) {
        model.addAttribute("idGenre", idGenre);
        return artistsServices.findByGenre(idGenre);
    }

}