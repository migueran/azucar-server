package com.mrando.azucardj.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mrando.azucardj.model.Artist;

@Repository
public interface ArtistsRepository extends JpaRepository<Artist, Integer> {
    Optional<Artist> findByName(String name);
    List<Artist> findByGenre(Integer idGenre);
}