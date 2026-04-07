package com.mrando.azucardj.service.Interfaces;

import java.util.List;
import com.mrando.azucardj.model.Genre;

public interface IGenresServices {
    List<Genre> fetch();
    void save(Genre genre);
    Genre findById(Integer idGenre);
    Genre findByName(String name);
    Genre update(Integer idGenre, Genre genre);
    void delete(Integer idGenre);
}