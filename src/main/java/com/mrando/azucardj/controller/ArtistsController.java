package com.mrando.azucardj.controller;

import org.springframework.ui.Model;

import java.util.List;

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
    public List<Artist> fetchArtists() {
        return artistsServices.fetch();
    }

    @PostMapping
    public void saveArtist(@RequestBody Artist artist) {
        artistsServices.save(artist);
    }

    @GetMapping("/{id}")
    public Artist getArtistById(@PathVariable Integer id, Model model) {
        model.addAttribute("id", id);
        return artistsServices.searchById(id);
    }

    @GetMapping("/name/{name}")
    public Artist getArtistByName(@PathVariable String name, Model model) {
        model.addAttribute("name", name);
        return artistsServices.searchByName(name);
    }

    @GetMapping("/genero/{idGenre}")
    public List<Artist> getArtistByGenre(@PathVariable Integer idGenre, Model model) {
        model.addAttribute("idGenre", idGenre);
        return artistsServices.searchByGenre(idGenre);
    }

}