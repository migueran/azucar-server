package com.mrando.azucardj.service;

import java.util.List;
import java.util.Optional;

import com.mrando.azucardj.model.Genre;
import com.mrando.azucardj.repository.GenresRepository;
import com.mrando.azucardj.service.Interfaces.IGenresService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenresService implements IGenresService {

    @Autowired
	private GenresRepository repoGenres;

    @Override
    public List<Genre> fetch() {
        return (List<Genre>) repoGenres.findAll();
    }

    @Override
    public void save(Genre genre) {
        repoGenres.save(genre);
    }

    @Override
    public Genre findById(Integer idGenre) {
        Optional<Genre> genreOptional = repoGenres.findById(idGenre);
        if (genreOptional.isPresent()) {
            return genreOptional.get();
        }
        return null;
    }

    @Override
    public Genre update(Integer idGene, Genre genre) {
        Optional<Genre> genreOptional = repoGenres.findById(idGene);
        if (genreOptional.isPresent()) {
            Genre existingGenre = genreOptional.get();
            existingGenre.setName(genre.getName());
            return repoGenres.save(existingGenre);
        }
        return null;
    }

    @Override
    public void delete(Integer idGenre) {
        repoGenres.deleteById(idGenre);
    }

    @Override
    public Genre findByName(String name) {
        List<Genre> genresList = (List<Genre>) repoGenres.findAll();
        for (Genre genre : genresList) {
            if (genre.getName().toLowerCase().equals(name.replace("-", " ").toLowerCase())) {
                return genre;
            }
        }
        return null;
    }
}
