package com.mrando.azucardj.service.Interfaces;

import java.util.List;
import java.util.Optional;

import com.mrando.azucardj.model.Artist;

public interface IArtistsServices {
    List<Artist> fetch();
    void save(Artist artist);
    Optional<Artist> findById(Integer idArtist);
    Optional<Artist> findByName(String name);
    List<Artist> findByGenre(Integer idGenre);
}