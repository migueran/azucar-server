package com.mrando.azucardj.service.Interfaces;

import java.util.List;

import com.mrando.azucardj.model.Video;

public interface IVideosService {
    List<Video> fetch();
    void save(Video videoUrl);
    Video findById(Integer idVideo);
    Video findByName(String name);
    void delete(Integer id);
}