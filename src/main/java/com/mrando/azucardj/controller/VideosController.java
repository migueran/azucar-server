package com.mrando.azucardj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.mrando.azucardj.model.Video;
import com.mrando.azucardj.service.VideosServices;


@RestController
@RequestMapping("/videos")
public class VideosController {

    @Autowired
    private VideosServices videoService;

    @GetMapping
    public List<Video> fetch() {
        return videoService.fetch();
    }

    @GetMapping("/{id}")
    public Video getById(@PathVariable Integer id) {
        return videoService.findById(id);
    }

    @GetMapping("/name/{name}")
    public Video getByName(@PathVariable String name, Model model) {
        return videoService.findByName(name);
    }

    @PostMapping
    public void save(@RequestBody Video video) {
        videoService.save(video);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        videoService.delete(id);
    }
}