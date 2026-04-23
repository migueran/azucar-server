package com.mrando.azucardj.service.Interfaces;

import java.util.List;
import java.util.Optional;

import com.mrando.azucardj.model.Theme;

public interface IThemesService {
    List<Theme> fetch();
    void save(Theme theme);
    Optional<Theme> findById(Integer idTheme);
    List<Theme> findByGenre(Integer idGenre);
    List<Theme> findByArtist(Integer idArtist);
    List<Theme> findByName(String name);
}