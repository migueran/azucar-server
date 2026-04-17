package com.mrando.azucardj.controller;

import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;

import com.mrando.azucardj.model.Artist;
import com.mrando.azucardj.service.ArtistsServices;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/artists")
@Tag(name = "Artists", description = "Gestión de artistas")
public class ArtistsController {

    @Autowired
    private ArtistsServices artistsServices;

    @GetMapping
    @Operation(summary = "Listar artistas", description = "Retorna todos los artistas registrados")
    @ApiResponse(responseCode = "200", description = "Lista de artistas obtenida exitosamente")
    public List<Artist> fetch() {
        return artistsServices.fetch();
    }

    @PostMapping
    @Operation(summary = "Crear artista", description = "Registra un nuevo artista")
    @ApiResponse(responseCode = "200", description = "Artista creado exitosamente")
    public void save(@RequestBody Artist artist) {
        artistsServices.save(artist);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar artista por ID", description = "Retorna un artista dado su ID")
    @ApiResponse(responseCode = "200", description = "Artista encontrado")
    @ApiResponse(responseCode = "404", description = "Artista no encontrado")
    public Optional<Artist> getById(@PathVariable Integer id, Model model) {
        model.addAttribute("id", id);
        return artistsServices.findById(id);
    }

    @GetMapping("/name/{name}")
    @Operation(summary = "Buscar artista por nombre", description = "Retorna un artista dado su nombre")
    @ApiResponse(responseCode = "200", description = "Artista encontrado")
    @ApiResponse(responseCode = "404", description = "Artista no encontrado")
    public Optional<Artist> getByName(@PathVariable String name, Model model) {
        model.addAttribute("name", name);
        return artistsServices.findByName(name);
    }

    @GetMapping("/genero/{idGenre}")
    @Operation(summary = "Buscar artistas por género", description = "Retorna artistas que pertenecen al género indicado")
    @ApiResponse(responseCode = "200", description = "Lista de artistas obtenida exitosamente")
    public List<Artist> getByGenre(@PathVariable Integer idGenre, Model model) {
        model.addAttribute("idGenre", idGenre);
        return artistsServices.findByGenre(idGenre);
    }

}