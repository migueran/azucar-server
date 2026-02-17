package com.mrando.azucardj.service;

import java.util.List;

import com.mrando.azucardj.model.Video;
import org.springframework.stereotype.Service;

@Service
public class VideosServices implements IVideosServices {

    private List<Video> VideosMocka = null;
    VideosServices() {
        VideosMocka = new java.util.LinkedList<Video>();
        VideosMocka.add( new Video(
            401, "Bohemian Rhapsody", "https://www.youtube.com/watch?v=fJ9rUzIMcZQ"
         ));
        VideosMocka.add( new Video(
            402, "Imagine", "https://www.youtube.com/watch?v=YkgkThdzX-8"
         ));
        VideosMocka.add( new Video(
            403, "Hotel California", "https://www.youtube.com/watch?v=EqPtz5qN7HM"
         ));
        VideosMocka.add( new Video(
            404, "Stairway to Heaven", "https://www.youtube.com/watch?v=QkF3oxziUI4"
         ));
        VideosMocka.add( new Video(
            405, "Smells Like Teen Spirit", "https://www.youtube.com/watch?v=hTWKbfoikeg"
         ));
        VideosMocka.add( new Video(
            406, "Billie Jean", "https://www.youtube.com/watch?v=Zi_XLOBDo_Y"
         ));
        VideosMocka.add( new Video(
            407, "Like a Rolling Stone", "https://www.youtube.com/watch?v=IwOfCgkyEj0"
         ));
        VideosMocka.add( new Video(
            408, "Hey Jude", "https://www.youtube.com/watch?v=A_MjCqQoLLA"
         ));
        VideosMocka.add( new Video(
            409, "Purple Rain", "https://www.youtube.com/watch?v=TvnYmWpD_T8"
         ));
        VideosMocka.add( new Video(
            410, "Wonderwall", "https://www.youtube.com/watch?v=bx1Bh8ZvH84"
         ));

    }

    @Override
    public List<Video> fetch() {
        return VideosMocka;
    }

    @Override
    public void save(Video Video) {
        VideosMocka.add(Video);
    }

    @Override
    public Video searchById(Integer idVideo) {
        for (Video video : VideosMocka) {
            if (video.getId().equals(idVideo)) {
                return video;
            }
        }
        return null;
    }

    @Override
    public Video searchByName(String name) {
        for (Video video : VideosMocka) {
            if (video.getName().toLowerCase().equals(name.replace("-", " ").toLowerCase())) {
                return video;
            }
        }
        return null;
    }

}