package com.mrando.azucardj.service;

import java.util.List;

import com.mrando.azucardj.model.Artist;

public class ArtistsServices implements IArtistsServices {

    @Override
    public List<String> fetch() {
        return null;
    }

    @Override
    public void save(String artist) {
    }

    @Override
    public String searchByName(String name) {
        return null;
    }

    @Override
    public Artist searchById(Integer idArtist) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchById'");
    }

    @Override
    public List<Artist> searchByGenre(Integer idGenre) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchByGenre'");
    }
}