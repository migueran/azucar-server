package com.mrando.azucardj.service;

import java.util.List;

import com.mrando.azucardj.model.Artist;

public interface IArtistsServices {
    List<Artist> fetch();
    void save(Artist artist);
    Artist searchByName(String name);
    Artist searchById(Integer idArtist);
    List<Artist> searchByGenre(Integer idGenre);
}