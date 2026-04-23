package com.mrando.azucardj.service.Interfaces;

import java.util.List;

import com.mrando.azucardj.model.User;

public interface IUsersService {
    public List<User> fetch();
    public User save(User user);
    public User findById(Integer id);
    public List<User> fetchDisabled();
    public User update(Integer id, User user);
    public void delete(Integer id);
    public void disable(Integer id);
    public void enable(Integer id);
}
