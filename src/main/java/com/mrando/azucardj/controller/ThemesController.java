package com.mrando.azucardj.controller;

import java.util.List;

import com.mrando.azucardj.model.Theme;
import com.mrando.azucardj.service.ThemesServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/themes")
public class ThemesController {

    @Autowired
    private ThemesServices themesServices;

    @GetMapping
    public List<Theme> fetchThemes() {
        return themesServices.fetch();
    }

    @PostMapping
    public void saveTheme(@RequestBody Theme theme) {
        themesServices.save(theme);
    }

    @GetMapping("/{id}")
    public Theme getThemeById(@PathVariable Integer id, Model model) {
        model.addAttribute("id", id);
        return themesServices.searchById(id);
    }

    @GetMapping("/name/{name}")
    public List<Theme> getThemesByName(@PathVariable String name, Model model) {
        model.addAttribute("name", name);
        return themesServices.searchByName(name);
    }

    @GetMapping("/artist/{idArtist}")
    public List<Theme> getThemesByArtist(@PathVariable Integer idArtist, Model model) {
        model.addAttribute("idArtist", idArtist);
        return themesServices.searchByArtist(idArtist);
    }

    @GetMapping("/genre/{idGenre}")
    public List<Theme> getThemesByGenre(@PathVariable Integer idGenre, Model model) {
        model.addAttribute("idGenre", idGenre);
        return themesServices.searchByGenre(idGenre);
    }
}