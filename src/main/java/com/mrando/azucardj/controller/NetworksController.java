package com.mrando.azucardj.controller;

import java.util.List;

import com.mrando.azucardj.model.Network;
import com.mrando.azucardj.service.NetworksServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/networks")
public class NetworksController {

    @Autowired
    private NetworksServices networksServices;

    @GetMapping
    public List<Network> fetch() {
        return networksServices.fetch();
    }

    @PostMapping
    public void save(@RequestBody Network network) {
        networksServices.save(network);
    }

    @GetMapping("/{id}")
    public Network getById(@PathVariable Integer id, Model model) {
        model.addAttribute("id", id);
        return networksServices.findById(id);
    }

    @PutMapping("/{id}")
    public Network update(@PathVariable Integer id, @RequestBody Network network) {
        return networksServices.update(id, network);
    }

    @GetMapping("/name/{name}")
    public Network getByName(@PathVariable String name, Model model) {
        model.addAttribute("name", name);
        return networksServices.findByName(name);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        networksServices.delete(id);
    }
}