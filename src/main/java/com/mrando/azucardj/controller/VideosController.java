package com.mrando.azucardj.controller;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.mrando.azucardj.model.Video;
import com.mrando.azucardj.service.VideosService;


@RestController
@RequestMapping("/videos")
@Tag(name = "Videos", description = "Gestión de videos musicales")
public class VideosController {

    @Autowired
    private VideosService videoService;

    @GetMapping
    @Operation(summary = "Listar videos", description = "Retorna todos los videos registrados")
    @ApiResponse(responseCode = "200", description = "Lista de videos obtenida exitosamente")
    public List<Video> fetch() {
        return videoService.fetch();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar video por ID", description = "Retorna un video dado su ID")
    @ApiResponse(responseCode = "200", description = "Video encontrado")
    @ApiResponse(responseCode = "404", description = "Video no encontrado")
    public Video getById(@PathVariable Integer id) {
        return videoService.findById(id);
    }

    @GetMapping("/name/{name}")
    @Operation(summary = "Buscar video por nombre", description = "Retorna un video dado su nombre")
    @ApiResponse(responseCode = "200", description = "Video encontrado")
    @ApiResponse(responseCode = "404", description = "Video no encontrado")
    public Video getByName(@PathVariable String name, Model model) {
        return videoService.findByName(name);
    }

    @PostMapping
    @Operation(summary = "Crear video", description = "Registra un nuevo video")
    @ApiResponse(responseCode = "200", description = "Video creado exitosamente")
    public void save(@RequestBody Video video) {
        videoService.save(video);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar video", description = "Actualiza los datos de un video existente")
    @ApiResponse(responseCode = "200", description = "Video actualizado exitosamente")
    public void update(@PathVariable Integer id, @RequestBody Video video) {
        Video existingVideo = videoService.findById(id);
        if (existingVideo != null) {
            Video updatedVideo = existingVideo.update(video);
            videoService.save(updatedVideo);
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar video", description = "Elimina un video dado su ID")
    @ApiResponse(responseCode = "200", description = "Video eliminado exitosamente")
    @ApiResponse(responseCode = "404", description = "Video no encontrado")
    public void delete(@PathVariable Integer id) {
        videoService.delete(id);
    }
}