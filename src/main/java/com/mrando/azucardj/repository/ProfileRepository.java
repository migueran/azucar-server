package com.mrando.azucardj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mrando.azucardj.model.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer> {

}
