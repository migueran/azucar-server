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
    public List<Item> fetchItems() {
        return itemsServices.fetch();
    }

    @PostMapping
    public void saveItem(@RequestBody Item item) {
        itemsServices.save(item);
    }

    @GetMapping("/{id}")
    public Item getItemById(@PathVariable Integer id, Model model) {
        model.addAttribute("id", id);
        return itemsServices.searchById(id);
    }

    @GetMapping("/owner/{idOwner}")
    public List<Item> getByOwner(@RequestParam Integer idOwner, Model model) {
        model.addAttribute("idOwner", idOwner);
        return itemsServices.searchByOwner(idOwner);
    }

    @GetMapping("/theme/{idTheme}")
    public List<Item> getByTheme(@RequestParam String idTheme, Model model) {
        model.addAttribute("idTheme", idTheme);
        return itemsServices.searchByTheme(Integer.parseInt(idTheme));
    }

}