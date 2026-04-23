package com.mrando.azucardj.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrando.azucardj.model.Role;
import com.mrando.azucardj.repository.RolesRepository;
import com.mrando.azucardj.service.Interfaces.IRolesService;

@Service
public class RolesService implements IRolesService {

  @Autowired
   private RolesRepository repoRoles;

  @Override
  public List<Role> fetch() {
    return (List<Role>) repoRoles.findAll();
  }

  @Override
  public void save(Role role) {
    repoRoles.save(role);
  }

  @Override
  public Role findById(Integer idRole) {
        Optional<Role> roleOptional = repoRoles.findById(idRole);
      if (roleOptional.isPresent()) {
        return roleOptional.get();
      }
      return null;
  }

@Override
   public Role update(Integer idRole, Role role) {
    Optional<Role> roleOptional = repoRoles.findById(idRole);
    if (roleOptional.isPresent()) {
        Role existingRole = roleOptional.get();
        existingRole.setRole(role.getRole()); //mrando
        return repoRoles.save(existingRole);
    }
    return null;
   }

  @Override
  public void delete(Integer id) {
    repoRoles.deleteById(id);
  }

  public Role findByRole(String name) {
    List<Role> rolesList = (List<Role>) repoRoles.findAll();
    for (Role role : rolesList) {
        if (role.getRole().toLowerCase().equals(name.replace("-", " ").toLowerCase())) {
            return role;
        }
    }
    return null;
   }

}
