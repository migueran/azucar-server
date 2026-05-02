package com.mrando.azucardj.service;

import com.mrando.azucardj.repository.ArtistsRepository;
import com.mrando.azucardj.service.Interfaces.IArtistsService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mrando.azucardj.model.Artist;

@Service
public class ArtistsService implements IArtistsService {

    @Autowired
    private ArtistsRepository artistsRepository;

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
