package com.mrando.azucardj.controller;

import java.util.List;

import com.mrando.azucardj.model.Item;
import com.mrando.azucardj.service.ItemsServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/items")
public class ItemsController {

    @Autowired
    private ItemsServices itemsServices;

    @GetMapping
    public List<Item> fetchItems() {
        return itemsServices.fetch();
    }

    @PostMapping
    public void saveItem(@RequestBody Item item) {
        itemsServices.save(item);
    }

    @GetMapping("/{id}")
    public Item getItemById(@PathVariable Integer id) {
        return itemsServices.searchById(id);
    }
}