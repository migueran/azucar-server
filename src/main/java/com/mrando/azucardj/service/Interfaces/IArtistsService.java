package com.mrando.azucardj.service.Interfaces;

import com.mrando.azucardj.model.Artist;
import java.util.List;
import java.util.Optional;

public interface IArtistsService {
    List<Artist> fetch();
    void save(Artist artist);
    Optional<Artist> findById(Integer id);
    Optional<Artist> findByName(String name);
    List<Artist> findByGenre(Integer idGenre);
}
