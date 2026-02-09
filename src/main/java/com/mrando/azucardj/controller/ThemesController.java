package com.mrando.azucardj.controller;

import java.util.List;

import com.mrando.azucardj.model.Theme;
import com.mrando.azucardj.service.ThemesServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Theme getThemeById(@PathVariable Integer id) {
        return themesServices.searchById(id);
    }
}