package com.mrando.azucardj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mrando.azucardj.model.Role;
import com.mrando.azucardj.service.RolesService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/roles")
@Tag(name = "Roles", description = "Gestión de roles de usuario")
public class RolesController {

    @Autowired
    private RolesService rolesService;

    @GetMapping
    @Operation(summary = "Listar roles", description = "Retorna todos los roles de usuario registrados")
    @ApiResponse(responseCode = "200", description = "Lista de roles obtenida exitosamente")
    public List<Role> fetch() {
        try {
            return rolesService.fetch();
        } catch (Exception e) {
            throw e;
        }
    }

    @PostMapping
    @Operation(summary = "Crear rol", description = "Registra un nuevo rol de usuario")
    @ApiResponse(responseCode = "200", description = "Rol creado exitosamente")
    public void save(@RequestBody Role role) {
        try {
            rolesService.save(role);
        } catch (Exception e) {
            throw e;
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar rol por ID", description = "Retorna un rol de usuario dado su ID")
    @ApiResponse(responseCode = "200", description = "Rol encontrado")
    @ApiResponse(responseCode = "404", description = "Rol no encontrado")
    public Role getById(@PathVariable Integer id, Model model) {
        try {
            model.addAttribute("id", id);
            return rolesService.findById(id);
        } catch (Exception e) {
            throw e;
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar rol", description = "Actualiza un rol de usuario dado su ID")
    @ApiResponse(responseCode = "200", description = "Rol actualizado exitosamente")
    @ApiResponse(responseCode = "404", description = "Rol no encontrado")
    public Role update(@PathVariable Integer id, @RequestBody Role role) {
        System.err.println("ID: " + id + role);
        System.err.println(role.getRole());
        try {
            return rolesService.update(id, role);
        } catch (Exception e) {
            throw e;
        }
    }

    @GetMapping("/role/{name}")
    @Operation(summary = "Buscar rol por nombre", description = "Retorna un rol de usuario dado su nombre")
    @ApiResponse(responseCode = "200", description = "Rol encontrado")
    @ApiResponse(responseCode = "404", description = "Rol no encontrado")
    public Role getByName(@PathVariable String name, Model model) {
        try {
            model.addAttribute("role", name);
            return rolesService.findByRole(name);
        } catch (Exception e) {
            throw e;
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar rol", description = "Elimina un rol de usuario dado su ID")
    @ApiResponse(responseCode = "200", description = "Rol eliminado exitosamente")
    @ApiResponse(responseCode = "404", description = "Rol no encontrado")
    public void delete(@PathVariable Integer id) {
        try {
            rolesService.delete(id);
        } catch (Exception e) {
            throw e;
        }
    }


}
