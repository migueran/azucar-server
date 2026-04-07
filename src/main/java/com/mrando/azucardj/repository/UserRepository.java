package com.mrando.azucardj.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mrando.azucardj.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByName(String name);
    List<User> findByStatus(Integer status);
}
