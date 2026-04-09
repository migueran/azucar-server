package com.mrando.azucardj.controller;

import java.util.List;
import java.util.Optional;

import com.mrando.azucardj.model.Theme;
import com.mrando.azucardj.service.ThemesServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/themes")
public class ThemesController {

    @Autowired
    private ThemesServices themesServices;

    @GetMapping
    public List<Theme> fetch() {
        return themesServices.fetch();
    }

    @PostMapping
    public void save(@RequestBody Theme theme) {
        themesServices.save(theme);
    }

    @GetMapping("/{id}")
    public Optional<Theme> getById(@PathVariable Integer id, Model model) {
        model.addAttribute("id", id);
        return themesServices.findById(id);
    }

    @GetMapping("/name/{name}")
    public List<Theme> getByName(@PathVariable String name, Model model) {
        model.addAttribute("name", name);
        return themesServices.findByName(name);
    }

    @GetMapping("/artist/{idArtist}")
    public List<Theme> getByArtist(@PathVariable Integer idArtist, Model model) {
        model.addAttribute("idArtist", idArtist);
        return themesServices.findByArtist(idArtist);
    }

    @GetMapping("/genre/{idGenre}")
    public List<Theme> getByGenre(@PathVariable Integer idGenre, Model model) {
        model.addAttribute("idGenre", idGenre);
        return themesServices.findByGenre(idGenre);
    }
}