package com.mrando.azucardj.repository;

// import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mrando.azucardj.model.Item;

@Repository
public interface ItemsRepository extends JpaRepository<Item, Integer> {
    // List<Item> findByThemeId(Integer themeId);
    // List<Item> findByAuthorId(Integer authorId);
    // List<Item> findByOwner(Integer idOwner);
    // List<Item> findByGenre(Integer idGenre);
}