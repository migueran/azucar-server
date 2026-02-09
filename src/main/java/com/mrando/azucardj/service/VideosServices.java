package com.mrando.azucardj.service;

import java.util.List;

import com.mrando.azucardj.model.Video;

public class VideosServices implements IVideosServices {

    @Override
    public List<String> fetch() {
        return null;
    }

    @Override
    public void save(String videoUrl) {
    }

    @Override
    public String searchById(Integer idVideo) {
        return null;
    }

    @Override
    public List<Video> searchByGenre(Integer idGenre) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchByGenre'");
    }

    @Override
    public List<Video> searchByArtist(Integer idArtist) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchByArtist'");
    }
}