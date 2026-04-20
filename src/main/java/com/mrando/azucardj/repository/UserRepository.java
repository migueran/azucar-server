package com.mrando.azucardj.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mrando.azucardj.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByStatus(Integer status);
    Optional<User> findByUsername(String username);
}
