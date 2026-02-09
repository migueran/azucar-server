package com.mrando.azucardj.controller;

import java.util.List;

import com.mrando.azucardj.model.DjList;
import com.mrando.azucardj.service.DjListServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Lists")
public class DjListsController {

    @Autowired
    private DjListServices DjListServices;

    @GetMapping
    public List<DjList> fetchLists() {
        return DjListServices.fetch();
    }

    @PostMapping
    public void saveDjList(@RequestBody DjList djList) {
        DjListServices.save(djList);
    }

    @GetMapping("/{id}")
    public DjList getDjListById(@PathVariable Integer id) {
        return DjListServices.searchById(id);
    }
}