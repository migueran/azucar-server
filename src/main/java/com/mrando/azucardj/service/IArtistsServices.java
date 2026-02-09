package com.mrando.azucardj.service;

import java.util.List;

import com.mrando.azucardj.model.Artist;

public interface IArtistsServices {
    List<String> fetch();
    void save(String artist);
    String searchByName(String name);
    Artist searchById(Integer idArtist);
    List<Artist> searchByGenre(Integer idGenre);
}