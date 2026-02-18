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
    public List<Network> fetchNetworks() {
        return networksServices.fetch();
    }

    @PostMapping
    public void saveNetwork(@RequestBody Network network) {
        networksServices.save(network);
    }

    @GetMapping("/{id}")
    public Network getNetworkById(@PathVariable Integer id, Model model) {
        model.addAttribute("id", id);
        return networksServices.getById(id);
    }

    @PutMapping("/{id}")
    public Network updateNetworkById(@PathVariable Integer id, @RequestBody Network network) {
        return networksServices.updateById(id, network);
    }

    @GetMapping("/name/{name}")
    public Network getNetworkByName(@PathVariable String name, Model model) {
        model.addAttribute("name", name);
        return networksServices.getByName(name);
    }

    @DeleteMapping("/{id}")
    public void deleteNetworkById(@PathVariable Integer id) {
        networksServices.deleteById(id);
    }
}