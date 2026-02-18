package com.mrando.azucardj.service;

import java.util.List;
import com.mrando.azucardj.model.Genre;

public interface IGenresServices {
    List<Genre> fetch();
    void save(Genre genre);
    Genre searchById(Integer idGenre);
    Genre updateById(Integer idGenre, Genre genre);
    void deleteById(Integer idGenre);
    Genre searchByName(String name);
}