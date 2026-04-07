package com.mrando.azucardj.controller;

import java.util.List;

import com.mrando.azucardj.model.Item;
import com.mrando.azucardj.service.ItemsServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/items")
public class ItemsController {

    @Autowired
    private ItemsServices itemsServices;

    @GetMapping
    public List<Item> fetch() {
        return itemsServices.fetch();
    }

    @PostMapping
    public void save(@RequestBody Item item) {
        itemsServices.save(item);
    }

    @GetMapping("/{id}")
    public Item getById(@PathVariable Integer id, Model model) {
        model.addAttribute("id", id);
        return itemsServices.findById(id);
    }

    @GetMapping("/owner/{idOwner}")
    public List<Item> getByOwner(@RequestParam Integer idOwner, Model model) {
        model.addAttribute("idOwner", idOwner);
        return itemsServices.findByOwner(idOwner);
    }

    @GetMapping("/theme/{idTheme}")
    public List<Item> getByTheme(@RequestParam Integer idTheme, Model model) {
        model.addAttribute("idTheme", idTheme);
        return itemsServices.findByTheme(idTheme);
    }

}