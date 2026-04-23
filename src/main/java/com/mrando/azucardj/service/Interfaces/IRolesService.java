package com.mrando.azucardj.service.Interfaces;

import java.util.List;
import com.mrando.azucardj.model.Role;

public interface IRolesService {
  List<Role> fetch();
  void save(Role role);
  Role findById(Integer idRole);
  Role findByRole(String name);
  Role update(Integer idRole, Role role);
  void delete(Integer id);
}
