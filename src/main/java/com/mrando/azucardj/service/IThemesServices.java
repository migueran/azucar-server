package com.mrando.azucardj.service;

import java.util.List;
import com.mrando.azucardj.model.Theme;

public interface IThemesServices {
    List<Theme> fetch();
    void save(Theme theme);
    Theme searchById(Integer idTheme);
    List<Theme> searchByGenre(Integer idGenre);
    List<Theme> searchByArtist(Integer idArtist);
}