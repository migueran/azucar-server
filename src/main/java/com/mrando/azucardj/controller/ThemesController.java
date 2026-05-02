package com.mrando.azucardj.controller;

import java.util.List;
import java.util.Optional;
import com.mrando.azucardj.model.Theme;
import com.mrando.azucardj.service.ThemesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/themes")
@Tag(name = "Themes", description = "Gestión de temas musicales")
public class ThemesController {

    @Autowired
    private ThemesService themesService;

    @GetMapping
    @Operation(summary = "Listar temas", description = "Retorna todos los temas musicales")
    @ApiResponse(responseCode = "200", description = "Lista de temas obtenida exitosamente")
    public List<Theme> fetch() {
        try {
            return themesService.fetch();
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener los temas", e);
        }
    }

    @PostMapping
    @Operation(summary = "Crear tema", description = "Registra un nuevo tema musical")
    @ApiResponse(responseCode = "200", description = "Tema creado exitosamente")
    public void save(@RequestBody Theme theme) {
        try {
            themesService.save(theme);
        } catch (Exception e) {
            throw new RuntimeException("Error al crear el tema", e);
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar tema", description = "Actualiza un tema musical existente")
    @ApiResponse(responseCode = "200", description = "Tema actualizado exitosamente")
    public void update(@PathVariable Integer id, @RequestBody Theme theme) {
        try {
            themesService.update(id, theme);
        } catch (Exception e) {
            throw new RuntimeException("Error al actualizar el tema", e);
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar tema por ID", description = "Retorna un tema dado su ID")
    @ApiResponse(responseCode = "200", description = "Tema encontrado")
    @ApiResponse(responseCode = "404", description = "Tema no encontrado")
    public Optional<Theme> getById(@PathVariable Integer id) {
        try {
            return themesService.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener el tema", e);
        }
    }

    @GetMapping("/name/{name}")
    @Operation(summary = "Buscar temas por nombre", description = "Retorna temas que coincidan con el nombre dado")
    @ApiResponse(responseCode = "200", description = "Lista de temas obtenida exitosamente")
    public List<Theme> getByName(@PathVariable String name) {
        try {
            return themesService.findByName(name);
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener los temas por nombre", e);
        }
    }

    @GetMapping("/artist/{idArtist}")
    @Operation(summary = "Buscar temas por artista", description = "Retorna temas asociados a un artista dado su ID")
    @ApiResponse(responseCode = "200", description = "Temas del artista obtenidos exitosamente")
    public List<Theme> getByArtist(@PathVariable Integer idArtist) {
        try {
            return themesService.findByArtist(idArtist);
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener los temas por artista", e);
        }
    }

    @GetMapping("/genre/{idGenre}")
    @Operation(summary = "Buscar temas por género", description = "Retorna temas asociados a un género dado su ID")
    @ApiResponse(responseCode = "200", description = "Temas del género obtenidos exitosamente")
    public List<Theme> getByGenre(@PathVariable Integer idGenre) {
        try {
            return themesService.findByGenre(idGenre);
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener los temas por género", e);
        }
    }
}