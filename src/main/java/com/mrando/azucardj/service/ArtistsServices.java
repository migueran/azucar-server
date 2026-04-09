package com.mrando.azucardj.service;

import com.mrando.azucardj.repository.ArtistsRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.mrando.azucardj.model.Artist;
import com.mrando.azucardj.service.Interfaces.IArtistsServices;

@Service
public class ArtistsServices implements IArtistsServices {

    // public List<Artist> artistsMocka = null;
    // public ArtistsServices() {
    //     artistsMocka = new java.util.LinkedList<Artist>();
    //     artistsMocka.add( new Artist(
    //         201, "Queen", 501
    //     ));
    //     artistsMocka.add( new Artist(
    //         202, "John Lennon", 502
    //     ));
    //     artistsMocka.add( new Artist(
    //         203, "Eagles", 503
    //     ));
    //     artistsMocka.add( new Artist(
    //         204, "Led Zeppelin", 504
    //     ));
    //     artistsMocka.add( new Artist(
    //         205, "Nirvana", 505
    //     ));
    //     artistsMocka.add( new Artist(
    //         206, "Michael Jackson", 506
    //     ));
    //     artistsMocka.add( new Artist(
    //         207, "Bob Dylan", 507
    //     ));
    //     artistsMocka.add( new Artist(
    //         208, "The Beatles", 508
    //     ));
    //     artistsMocka.add( new Artist(
    //         209, "Prince", 509
    //     ));
    //     artistsMocka.add( new Artist(
    //         210, "Oasis", 510
    //     ));
    // }

    private final ArtistsRepository artistsRepository;

  ArtistsServices(ArtistsRepository artistsRepository) {
    this.artistsRepository = artistsRepository;
  }

    @Override
    public List<Artist> fetch() {
        return artistsRepository.findAll();
    }

    @Override
    public void save(Artist artist) {
        artistsRepository.save(artist);
    }

    @Override
    public Optional<Artist> findById(Integer id) {
		return artistsRepository.findById(id);
    }

    @Override
    public Optional<Artist> findByName(String name) {
		return artistsRepository.findByName(name);
    }

    @Override
    public List<Artist> findByGenre(Integer idGenre) {
		return artistsRepository.findByGenre(idGenre);
    }

}
