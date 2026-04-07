package com.mrando.azucardj.service.Interfaces;

import java.util.List;

import com.mrando.azucardj.model.Artist;

public interface IArtistsServices {
    List<Artist> fetch();
    void save(Artist artist);
    Artist findById(Integer idArtist);
    Artist findByName(String name);
    List<Artist> findByGenre(Integer idGenre);
}