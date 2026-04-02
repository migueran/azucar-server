package com.mrando.azucardj.service;

import java.util.List;

import com.mrando.azucardj.model.Video;
import com.mrando.azucardj.repository.VideosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideosServices implements IVideosServices {

    // private List<Video> VideosMocka = null;
    // VideosServices() {
        // VideosMocka = new java.util.LinkedList<Video>();
        // VideosMocka.add( new Video(
        //     401, "Bohemian Rhapsody", "https://www.youtube.com/watch?v=fJ9rUzIMcZQ"
        //  ));
        // VideosMocka.add( new Video(
        //     402, "Imagine", "https://www.youtube.com/watch?v=YkgkThdzX-8"
        //  ));
        // VideosMocka.add( new Video(
        //     403, "Hotel California", "https://www.youtube.com/watch?v=EqPtz5qN7HM"
        //  ));
        // VideosMocka.add( new Video(
        //     404, "Stairway to Heaven", "https://www.youtube.com/watch?v=QkF3oxziUI4"
        //  ));
        // VideosMocka.add( new Video(
        //     405, "Smells Like Teen Spirit", "https://www.youtube.com/watch?v=hTWKbfoikeg"
        //  ));
        // VideosMocka.add( new Video(
        //     406, "Billie Jean", "https://www.youtube.com/watch?v=Zi_XLOBDo_Y"
        //  ));
        // VideosMocka.add( new Video(
        //     407, "Like a Rolling Stone", "https://www.youtube.com/watch?v=IwOfCgkyEj0"
        //  ));
        // VideosMocka.add( new Video(
        //     408, "Hey Jude", "https://www.youtube.com/watch?v=A_MjCqQoLLA"
        //  ));
        // VideosMocka.add( new Video(
        //     409, "Purple Rain", "https://www.youtube.com/watch?v=TvnYmWpD_T8"
        //  ));
        // VideosMocka.add( new Video(
        //     410, "Wonderwall", "https://www.youtube.com/watch?v=bx1Bh8ZvH84"
        //  ));

    // }
    @Autowired
    private VideosRepository videoRepository;

    @Override
    public List<Video> fetch() {
        return videoRepository.findAll();
    }

    @Override
    public Video searchById(Integer idVideo) {
        return videoRepository.findById(idVideo).orElse(null);
    }

    @Override
    public Video searchByName(String name) {
        return videoRepository.findAll().stream()
            .filter(video -> video.getName().equalsIgnoreCase(name))
            .findFirst()
            .orElse(null);
    }

    @Override
    public void save(Video video) {
        videoRepository.save(video);
    }

    @Override
    public void deleteById(Integer id) {
        videoRepository.deleteById(id);
    }

}