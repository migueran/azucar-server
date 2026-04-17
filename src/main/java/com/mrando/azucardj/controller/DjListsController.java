package com.mrando.azucardj.controller;

import java.util.List;

import com.mrando.azucardj.model.DjList;
import com.mrando.azucardj.service.DjListServices;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lists")
@Tag(name = "DjLists", description = "Gestión de listas de reproducción DJ")
public class DjListsController {

    @Autowired
    private DjListServices DjListServices;

    @GetMapping
    @Operation(summary = "Listar DjLists", description = "Retorna todas las listas de reproducción DJ")
    @ApiResponse(responseCode = "200", description = "Lista obtenida exitosamente")
    public List<DjList> fetch() {
        return DjListServices.fetch();
    }

    @PostMapping
    @Operation(summary = "Crear DjList", description = "Registra una nueva lista de reproducción DJ")
    @ApiResponse(responseCode = "200", description = "DjList creada exitosamente")
    public void save(@RequestBody DjList djList) {
        DjListServices.save(djList);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar DjList por ID", description = "Retorna una lista de reproducción dado su ID")
    @ApiResponse(responseCode = "200", description = "DjList encontrada")
    @ApiResponse(responseCode = "404", description = "DjList no encontrada")
    public DjList getById(@PathVariable Integer id, Model model) {
        model.addAttribute("id", id);
        return DjListServices.findById(id);
    }

    @GetMapping("/owner/{idOwner}")
    @Operation(summary = "Buscar DjLists por propietario", description = "Retorna listas de reproducción de un usuario dado su ID")
    @ApiResponse(responseCode = "200", description = "Listas del propietario obtenidas exitosamente")
    public List<DjList> getByOwner(@PathVariable Integer idOwner, Model model) {
        model.addAttribute("idOwner", idOwner);
        return DjListServices.findByOwner(idOwner);
    }
}