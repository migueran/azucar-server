package com.mrando.azucardj.controller;

import java.util.List;

import com.mrando.azucardj.service.ArtistsServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/artists")
public class ArtistsController {

    @Autowired
    private ArtistsServices artistsServices;

    @GetMapping
    public List<String> fetchArtists() {
        return artistsServices.fetch();
    }

    @PostMapping
    public void saveArtist(@RequestBody String artist) {
        artistsServices.save(artist);
    }

    @GetMapping("/{name}")
    public String getArtistByName(@PathVariable String name) {
        return artistsServices.searchByName(name);
    }
}