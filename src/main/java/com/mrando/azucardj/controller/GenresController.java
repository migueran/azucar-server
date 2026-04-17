package com.mrando.azucardj.controller;

import org.springframework.ui.Model;

import java.util.List;

import com.mrando.azucardj.model.Genre;
import com.mrando.azucardj.service.GenresServices;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/genres")
@Tag(name = "Genres", description = "Gestión de géneros musicales")
public class GenresController {

    @Autowired
    private GenresServices genresServices;

    @GetMapping
    @Operation(summary = "Listar géneros", description = "Retorna todos los géneros musicales")
    @ApiResponse(responseCode = "200", description = "Lista de géneros obtenida exitosamente")
    public List<Genre> fetch() {
        return genresServices.fetch();
    }

    @PostMapping
    @Operation(summary = "Crear género", description = "Registra un nuevo género musical")
    @ApiResponse(responseCode = "200", description = "Género creado exitosamente")
    public void save(@RequestBody Genre genre) {
        genresServices.save(genre);
    }

    @GetMapping("/{idGenre}")
    @Operation(summary = "Buscar género por ID", description = "Retorna un género dado su ID")
    @ApiResponse(responseCode = "200", description = "Género encontrado")
    @ApiResponse(responseCode = "404", description = "Género no encontrado")
    public Genre getById(@PathVariable Integer idGenre, Model model) {
        model.addAttribute("idGenre", idGenre);
        return genresServices.findById(idGenre);
    }

    @GetMapping("/name/{name}")
    @Operation(summary = "Buscar género por nombre", description = "Retorna un género dado su nombre")
    @ApiResponse(responseCode = "200", description = "Género encontrado")
    @ApiResponse(responseCode = "404", description = "Género no encontrado")
    public Genre getByNane(@PathVariable String name, Model model) {
        model.addAttribute("name", name);
        return genresServices.findByName(name);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar género", description = "Actualiza un género dado su ID")
    @ApiResponse(responseCode = "200", description = "Género actualizado exitosamente")
    @ApiResponse(responseCode = "404", description = "Género no encontrado")
    public Genre update(@PathVariable Integer id, @RequestBody Genre genre) {
        return genresServices.update(id, genre);
    }

    @DeleteMapping("/{idGenre}")
    @Operation(summary = "Eliminar género", description = "Elimina un género dado su ID")
    @ApiResponse(responseCode = "200", description = "Género eliminado exitosamente")
    @ApiResponse(responseCode = "404", description = "Género no encontrado")
    public void delete(@PathVariable Integer idGenre) {
        genresServices.delete(idGenre);
    }
}