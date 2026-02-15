package com.mrando.azucardj.controller;

import java.util.List;

import com.mrando.azucardj.model.DjList;
import com.mrando.azucardj.service.DjListServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
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
    public DjList getDjListById(@PathVariable Integer id, Model model) {
        model.addAttribute("id", id);
        return DjListServices.searchById(id);
    }

    @GetMapping("/owner/{idOwner}")
    public List<DjList> getDjListByOwner(@PathVariable Integer idOwner, Model model) {
        model.addAttribute("idOwner", idOwner);
        return DjListServices.searchByOwner(idOwner);
    }
}