package com.mrando.azucardj.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mrando.azucardj.model.DjList;

@Repository
public interface DjListRepository extends JpaRepository<DjList, Integer> {
    DjList findByName(String name);
    List<DjList> findByOwner(Integer idOwner);
}