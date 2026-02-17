package com.mrando.azucardj.service;

import java.util.List;
import com.mrando.azucardj.model.Genre;

public interface IGenresServices {
    List<Genre> fetch();
    void save(Genre genre);
    Genre searchById(Integer idGenre);
    void deleteById(Integer idGenre);
    Genre searchByName(String name);
}