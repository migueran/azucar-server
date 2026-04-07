package com.mrando.azucardj.service.Interfaces;

import java.util.List;
import com.mrando.azucardj.model.Theme;

public interface IThemesServices {
    List<Theme> fetch();
    void save(Theme theme);
    Theme findById(Integer idTheme);
    List<Theme> findByGenre(Integer idGenre);
    List<Theme> findByArtist(Integer idArtist);
    List<Theme> findByName(String name);
}