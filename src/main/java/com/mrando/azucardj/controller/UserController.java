package com.mrando.azucardj.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.mrando.azucardj.model.User;
import com.mrando.azucardj.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> fetch() {
        return userService.fetch();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable Integer id) {
        return userService.findById(id);
    }

    @GetMapping("/name/{name}")
    public String findByName(@PathVariable String name) {
        return name;
    }

    @GetMapping("/disabled")
    public List<User> fetchDisabled() {
        return userService.fetchDisabled();
    }

    @PostMapping
    public User create(@RequestBody User user) {
        return userService.save(user);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable Integer id, @RequestBody User user) {
        return userService.update(id, user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        userService.delete(id);
    }

    @PatchMapping("/{id}/disable")
    public void disable(@PathVariable Integer id) {
        userService.disable(id);
    }

    @PatchMapping("/{id}/enable")
    public void enable(@PathVariable Integer id) {
        userService.enable(id);
    }
}