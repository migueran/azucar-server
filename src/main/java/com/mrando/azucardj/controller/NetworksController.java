package com.mrando.azucardj.controller;

import java.util.List;
import com.mrando.azucardj.model.Network;
import com.mrando.azucardj.service.NetworksService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/networks")
@Tag(name = "Networks", description = "Gestión de redes sociales")
public class NetworksController {

    @Autowired
    private NetworksService networksService;

    @GetMapping
    @Operation(summary = "Listar redes", description = "Retorna todas las redes sociales registradas")
    @ApiResponse(responseCode = "200", description = "Lista de redes obtenida exitosamente")
    public List<Network> fetch() {
        try {
            return networksService.fetch();
        } catch (Exception e) {
            throw e;
        }
    }

    @PostMapping
    @Operation(summary = "Crear red", description = "Registra una nueva red social")
    @ApiResponse(responseCode = "200", description = "Red creada exitosamente")
    public void save(@RequestBody Network network, @AuthenticationPrincipal UserDetails userDetails) {
        List<String> userRole = userDetails.getAuthorities().stream()
                .map(auth -> auth.getAuthority())
                .toList();
         if ( !userRole.contains("admin")) {
            throw new RuntimeException("Acceso denegado: solo administradores pueden crear redes sociales");
         }
        try {
            networksService.save(network);
        } catch (Exception e) {
            throw e;
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar red por ID", description = "Retorna una red social dado su ID")
    @ApiResponse(responseCode = "200", description = "Red encontrada")
    @ApiResponse(responseCode = "404", description = "Red no encontrada")
    public Network getById(@PathVariable Integer id, Model model) {
        try {
            model.addAttribute("id", id);
            return networksService.findById(id);
        } catch (Exception e) {
            throw e;
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar red", description = "Actualiza una red social dado su ID")
    @ApiResponse(responseCode = "200", description = "Red actualizada exitosamente")
    @ApiResponse(responseCode = "404", description = "Red no encontrada")
    public Network update(
        @PathVariable Integer id,
        @RequestBody Network network,
        @AuthenticationPrincipal UserDetails userDetails
    ) {
        List<String> userRole = userDetails.getAuthorities().stream()
            .map(auth -> auth.getAuthority())
            .toList();
         if ( !userRole.contains("admin")) {
            throw new RuntimeException("Acceso denegado: solo administradores pueden modificar redes sociales");
         }
        try {
            return networksService.update(id, network);
        } catch (Exception e) {
            throw e;
        }
    }

    @GetMapping("/name/{name}")
    @Operation(summary = "Buscar red por nombre", description = "Retorna una red social dado su nombre")
    @ApiResponse(responseCode = "200", description = "Red encontrada")
    @ApiResponse(responseCode = "404", description = "Red no encontrada")
    public Network getByName(@PathVariable String name, Model model) {
        try {
            model.addAttribute("name", name);
            return networksService.findByName(name);
        } catch (Exception e) {
            throw e;
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar red", description = "Elimina una red social dado su ID")
    @ApiResponse(responseCode = "200", description = "Red eliminada exitosamente")
    @ApiResponse(responseCode = "404", description = "Red no encontrada")
    public void delete(@PathVariable Integer id, @AuthenticationPrincipal UserDetails userDetails) {
        List<String> userRole = userDetails.getAuthorities().stream()
            .map(auth -> auth.getAuthority())
            .toList();
         if ( !userRole.contains("admin")) {
            throw new RuntimeException("Acceso denegado: solo administradores pueden eliminar redes sociales");
         }
        try {
            networksService.delete(id);
        } catch (Exception e) {
            throw e;
        }
    }
}