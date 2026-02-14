package com.mrando.azucardj.service;

import java.util.List;

import com.mrando.azucardj.model.Video;

public interface IVideosServices {
    List<Video> fetch();
    void save(Video videoUrl);
    Video searchById(Integer idVideo);
    List<Video> searchByGenre(Integer idGenre);
    List<Video> searchByArtist(Integer idArtist);
}