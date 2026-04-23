package com.mrando.azucardj.controller;

import java.util.List;

import com.mrando.azucardj.model.Item;
import com.mrando.azucardj.service.ItemsService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/items")
@Tag(name = "Items", description = "Gestión de ítems de una DjList")
public class ItemsController {

    @Autowired
    private ItemsService itemsService;

    @GetMapping
    @Operation(summary = "Listar ítems", description = "Retorna todos los ítems registrados")
    @ApiResponse(responseCode = "200", description = "Lista de ítems obtenida exitosamente")
    public List<Item> fetch() {
        return itemsService.fetch();
    }

    @PostMapping
    @Operation(summary = "Crear ítem", description = "Registra un nuevo ítem en una DjList")
    @ApiResponse(responseCode = "200", description = "Ítem creado exitosamente")
    public void save(@RequestBody Item item) {
        itemsService.save(item);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar ítem por ID", description = "Retorna un ítem dado su ID")
    @ApiResponse(responseCode = "200", description = "Ítem encontrado")
    @ApiResponse(responseCode = "404", description = "Ítem no encontrado")
    public Item getById(@PathVariable Integer id, Model model) {
        model.addAttribute("id", id);
        return itemsService.findById(id);
    }

    @GetMapping("/owner/{idOwner}")
    @Operation(summary = "Buscar ítems por propietario", description = "Retorna ítems de un usuario dado su ID")
    @ApiResponse(responseCode = "200", description = "Ítems del propietario obtenidos exitosamente")
    public List<Item> getByOwner(@RequestParam Integer idOwner, Model model) {
        model.addAttribute("idOwner", idOwner);
        return itemsService.findByOwner(idOwner);
    }

    @GetMapping("/theme/{idTheme}")
    @Operation(summary = "Buscar ítems por tema", description = "Retorna ítems asociados a un tema dado su ID")
    @ApiResponse(responseCode = "200", description = "Ítems del tema obtenidos exitosamente")
    public List<Item> getByTheme(@RequestParam Integer idTheme, Model model) {
        model.addAttribute("idTheme", idTheme);
        return itemsService.findByTheme(idTheme);
    }

}