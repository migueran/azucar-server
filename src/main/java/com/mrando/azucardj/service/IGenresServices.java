package com.mrando.azucardj.service;

import java.util.List;
import com.mrando.azucardj.model.Genre;

public interface IGenresServices {
    List<Genre> fetch();
    void save(String genre);
    Genre searchById(Integer idGenre);
}