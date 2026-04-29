package com.mrando.azucardj.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrando.azucardj.model.User;
import com.mrando.azucardj.repository.UserRepository;
import com.mrando.azucardj.service.Interfaces.IUsersService;

@Service
public class UsersService implements IUsersService {

    @Autowired
    private UserRepository userRepository;

    public List<User> fetch() {
        return userRepository.findAll();
    }

    public User findById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    public List<User> fetchDisabled() {
        return userRepository.findByStatus(0); // Assuming 0 = disabled
    }

    public User save(User user) {
        user.setStatus(1); // Default to enabled
        return userRepository.save(user);
    }

    public User update(Integer id, User user) {
        Optional<User> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {
            User updatedUser = existingUser.get();
            updatedUser.setUsername(user.getUsername());
            updatedUser.setPassword(user.getPassword());
            updatedUser.setStatus(user.getStatus());
            return userRepository.save(updatedUser);
        }
        return null;
    }

    public void delete(Integer id) {
        userRepository.deleteById(id);
    }

    public void disable(Integer id) {
        Optional<User> user = userRepository.findById(id);
        user.ifPresent(u -> {
            u.setStatus(0); // Set status to disabled
            userRepository.save(u);
        });
    }

    public void enable(Integer id) {
        Optional<User> user = userRepository.findById(id);
        user.ifPresent(u -> {
            u.setStatus(1); // Set status to enabled
            userRepository.save(u);
        });
    }
}