package com.mrando.azucardj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mrando.azucardj.model.Role;

@Repository
public interface RolesRepository extends JpaRepository<Role, Integer> {

}
