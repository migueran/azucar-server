package com.mrando.azucardj.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mrando.azucardj.model.Theme;

@Repository
public interface ThemesRepository extends JpaRepository<Theme, Integer> {
    List<Theme> findByName(String name);
    List<Theme> findByGenre(Integer idGenre);
    List<Theme> findByArtist(Integer idArtist);
}