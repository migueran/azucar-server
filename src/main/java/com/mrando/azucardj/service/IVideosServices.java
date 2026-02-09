package com.mrando.azucardj.service;

import java.util.List;

import com.mrando.azucardj.model.Video;

public interface IVideosServices {
    List<String> fetch();
    void save(String videoUrl);
    String searchById(Integer idVideo);
    List<Video> searchByGenre(Integer idGenre);
    List<Video> searchByArtist(Integer idArtist);
}