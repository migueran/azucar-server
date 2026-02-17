package com.mrando.azucardj.service;

import java.util.List;
import java.util.Optional;

import com.mrando.azucardj.model.Genre;
import com.mrando.azucardj.repository.GenresRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenresServices implements IGenresServices {

    @Autowired
	private GenresRepository repoGenres;

    // public List<Genre> genresList = Arrays.asList(
    //     new Genre("Rock"),
    //     new Genre("Pop"),
    //     new Genre("Country Rock"),
    //     new Genre("Classic Rock"),
    //     new Genre("Grunge"),
    //     new Genre("Pop"),
    //     new Genre("Folk"),
    //     new Genre("Rock"),
    //     new Genre("Funk"),
    //     new Genre("Britpop")
    // );

    @Override
    public List<Genre> fetch() {
        return (List<Genre>) repoGenres.findAll();
    }

    @Override
    public void save(Genre genre) {
        repoGenres.save(genre);
    }

    @Override
    public Genre searchById(Integer idGenre) {
        Optional<Genre> genreOptional = repoGenres.findById(idGenre);
        if (genreOptional.isPresent()) {
            return genreOptional.get();
        }
        return null;
    }

    @Override
    public void deleteById(Integer idGenre) {
        repoGenres.deleteById(idGenre);
    }

    @Override
    public Genre searchByName(String name) {
        List<Genre> genresList = (List<Genre>) repoGenres.findAll();
        for (Genre genre : genresList) {
            if (genre.getName().toLowerCase().equals(name.replace("-", " ").toLowerCase())) {
                return genre;
            }
        }
        return null;
    }
}
