package com.mrando.azucardj.service;

import java.util.Arrays;
import java.util.List;
import com.mrando.azucardj.model.Genre;
import org.springframework.stereotype.Service;

@Service
public class GenresServices implements IGenresServices {

    public List<Genre> genresList = Arrays.asList(
        new Genre(501, "Rock"),
        new Genre(502, "Pop"),
        new Genre(503, "Country Rock"),
        new Genre(504, "Classic Rock"),
        new Genre(505, "Grunge"),
        new Genre(506, "Pop"),
        new Genre(507, "Folk"),
        new Genre(508, "Rock"),
        new Genre(509, "Funk"),
        new Genre(510, "Britpop")
    );
    @Override
    public List<Genre> fetch() {
        return genresList;
    }

    @Override
    public void save(Genre genre) {
        genresList.add(genre);
    }

    @Override
    public Genre searchById(Integer idGenre) {
        for (Genre genre : genresList) {
            if (genre.getId().equals(idGenre)) {
                return genre;
            }
        }
        return null;
    }

    @Override
    public Genre searchByName(String name) {
        for (Genre genre : genresList) {
            if (genre.getName().toLowerCase().equals(name.replace("-", " ").toLowerCase())) {
                return genre;
            }
        }
        return null;
    }
}