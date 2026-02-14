package com.mrando.azucardj.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.mrando.azucardj.model.Artist;

@Service
public class ArtistsServices implements IArtistsServices {

    public List<Artist> artistsMocka = null;
    public ArtistsServices() {
        artistsMocka = new java.util.LinkedList<Artist>();
        artistsMocka.add( new Artist(
            201, "Queen", 501
        ));
        artistsMocka.add( new Artist(
            202, "John Lennon", 502
        ));
        artistsMocka.add( new Artist(
            203, "Eagles", 503
        ));
        artistsMocka.add( new Artist(
            204, "Led Zeppelin", 504
        ));
        artistsMocka.add( new Artist(
            205, "Nirvana", 505
        ));
        artistsMocka.add( new Artist(
            206, "Michael Jackson", 506
        ));
        artistsMocka.add( new Artist(
            207, "Bob Dylan", 507
        ));
        artistsMocka.add( new Artist(
            208, "The Beatles", 508
        ));
        artistsMocka.add( new Artist(
            209, "Prince", 509
        ));
        artistsMocka.add( new Artist(
            510, "Oasis", 510
        ));
    }

    @Override
    public List<Artist> fetch() {
        return artistsMocka;
    }

    @Override
    public void save(Artist artist) {
        artistsMocka.add(artist);
    }

    @Override
    public Artist searchByName(String name) {
        for ( Artist art : artistsMocka) {
			if (art.getNameArtist() == name)
			    return art;
		}
		return null;
    }

    @Override
    public Artist searchById(Integer idArtist) {
        for ( Artist art : artistsMocka) {
			if (art.getId() == idArtist.intValue())
			    return art;
		}
		return null;
    }

    @Override
    public List<Artist> searchByGenre(Integer idGenre) {
        List<Artist> artistsByGenre = new java.util.LinkedList<Artist>();
        for ( Artist art : artistsMocka) {
			if (art.getGenre() == idGenre.intValue())
			    artistsByGenre.add(art);
		}
		return artistsByGenre;
    }

}
