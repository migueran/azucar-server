package com.mrando.azucardj.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mrando.azucardj.model.Artist;

@Repository
public interface ArtistsRepository extends JpaRepository<Artist, Integer> {
    @Query("SELECT a FROM Artist a WHERE a.name = ?1")
    Optional<Artist> findByName(String name);
    @Query("SELECT a FROM Artist a JOIN a.genre g WHERE g.id = ?1")
    List<Artist> findByGenre(Integer idGenre);
}