package com.mrando.azucardj.controller;

import java.util.List;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.mrando.azucardj.model.User;
import com.mrando.azucardj.service.UsersService;

@RestController
@RequestMapping("/users")
@Tag(name = "Users", description = "Gestión de usuarios")
public class UserController {

    @Autowired
    private UsersService usersService;

    @GetMapping
    @Operation(summary = "Listar usuarios", description = "Retorna todos los usuarios registrados")
    @ApiResponse(responseCode = "200", description = "Lista de usuarios obtenida exitosamente")
    public List<User> fetch() {
        return usersService.fetch();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar usuario por ID", description = "Retorna un usuario dado su ID")
    @ApiResponse(responseCode = "200", description = "Usuario encontrado")
    @ApiResponse(responseCode = "404", description = "Usuario no encontrado")
    public User findById(@PathVariable Integer id) {
        return usersService.findById(id);
    }

    @GetMapping("/name/{name}")
    @Operation(summary = "Buscar usuario por nombre", description = "Retorna el nombre de usuario dado")
    @ApiResponse(responseCode = "200", description = "Nombre de usuario retornado")
    public String findByName(@PathVariable String name) {
        return name;
    }

    @GetMapping("/disabled")
    @Operation(summary = "Listar usuarios deshabilitados", description = "Retorna todos los usuarios con status deshabilitado")
    @ApiResponse(responseCode = "200", description = "Lista de usuarios deshabilitados obtenida exitosamente")
    public List<User> fetchDisabled() {
        return usersService.fetchDisabled();
    }

    // @PostMapping
    // @Operation(summary = "Crear usuario", description = "Registra un nuevo usuario")
    // @ApiResponse(responseCode = "200", description = "Usuario creado exitosamente")
    // public User create(@RequestBody User user) {
    //     return usersService.save(user);
    // }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar usuario", description = "Actualiza los datos de un usuario dado su ID")
    @ApiResponse(responseCode = "200", description = "Usuario actualizado exitosamente")
    @ApiResponse(responseCode = "404", description = "Usuario no encontrado")
    public User update(@PathVariable Integer id, @RequestBody User user) {
        return usersService.update(id, user);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar usuario", description = "Elimina un usuario dado su ID")
    @ApiResponse(responseCode = "200", description = "Usuario eliminado exitosamente")
    @ApiResponse(responseCode = "404", description = "Usuario no encontrado")
    public void delete(@PathVariable Integer id) {
        usersService.delete(id);
    }

    @PatchMapping("/{id}/disable")
    @Operation(summary = "Deshabilitar usuario", description = "Cambia el status del usuario a deshabilitado")
    @ApiResponse(responseCode = "200", description = "Usuario deshabilitado exitosamente")
    @ApiResponse(responseCode = "404", description = "Usuario no encontrado")
    public void disable(@PathVariable Integer id) {
        usersService.disable(id);
    }

    @PatchMapping("/{id}/enable")
    @Operation(summary = "Habilitar usuario", description = "Cambia el status del usuario a habilitado")
    @ApiResponse(responseCode = "200", description = "Usuario habilitado exitosamente")
    @ApiResponse(responseCode = "404", description = "Usuario no encontrado")
    public void enable(@PathVariable Integer id) {
        usersService.enable(id);
    }
}