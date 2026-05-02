package com.mrando.azucardj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mrando.azucardj.model.Video;

@Repository
public interface VideosRepository extends JpaRepository<Video, Integer> {
    @Query("SELECT v FROM Video v WHERE v.name LIKE %:name%")
    Video findByName(String name);
}
