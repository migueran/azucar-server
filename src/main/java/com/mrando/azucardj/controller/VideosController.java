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
    public List<Video> fetchAllVideos() {
        return videoService.fetch();
    }

    @GetMapping("/{id}")
    public Video getVideoById(@PathVariable Integer id) {
        return videoService.searchById(id);
    }

    @GetMapping("/name/{name}")
    public Video getMethodName(@PathVariable String name, Model model) {
        return videoService.searchByName(name);
    }

    @PostMapping
    public void saveVideo(@RequestBody Video video) {
        videoService.save(video);
    }

    @DeleteMapping("/{id}")
    public void deleteVideoById(@PathVariable Integer id) {
        videoService.deleteById(id);
    }
}