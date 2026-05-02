package com.mrando.azucardj.service;

import java.util.List;

import com.mrando.azucardj.model.Video;
import com.mrando.azucardj.repository.VideosRepository;
import com.mrando.azucardj.service.Interfaces.IVideosService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideosService implements IVideosService {

    @Autowired
    private VideosRepository videoRepository;

    @Override
    public List<Video> fetch() {
        return videoRepository.findAll();
    }

    @Override
    public Video findById(Integer idVideo) {
        return videoRepository.findById(idVideo).orElse(null);
    }

    @Override
    public Video findByName(String name) {
        return videoRepository.findByName(name);
    }

    @Override
    public void save(Video video) {
        videoRepository.save(video);
    }

    @Override
    public void delete(Integer id) {
        videoRepository.deleteById(id);
    }

}