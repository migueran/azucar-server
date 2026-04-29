package com.mrando.azucardj.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.mrando.azucardj.service.ContactsService;
import com.mrando.azucardj.auth.AuthService;
import com.mrando.azucardj.model.Contact;
import com.mrando.azucardj.model.Profile;
import com.mrando.azucardj.model.User;


@RestController
@RequestMapping("/contacts")
@Tag(name = "Contacts", description = "Gestión de contactos de perfil")
public class ContactsController {

    @Autowired
    private ContactsService contactsService;
    @Autowired
    private AuthService authService;

    @GetMapping
    @Operation(summary = "Listar contactos", description = "Retorna todos los contactos registrados")
    @ApiResponse(responseCode = "200", description = "Lista de contactos obtenida exitosamente")
    public List<Contact> fetch() {
        try {
            return contactsService.fetch();
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener los contactos", e);
        }
    }

    @GetMapping("/by-user/{userId}")
    public List<Contact> getContactsByUserId(@PathVariable String userId) {
        return contactsService.findByUserId(userId);
    }

    @PostMapping
    @Operation(summary = "Crear contacto", description = "Registra un nuevo contacto de perfil")
    @ApiResponse(responseCode = "200", description = "Contacto creado exitosamente")
    public void save(@RequestBody Contact contact, @AuthenticationPrincipal UserDetails userDetails) {
        String username = userDetails.getUsername();
        try {
            contactsService.save(contact, username);
        } catch (Exception e) {
            throw new RuntimeException("Error al crear el contacto", e);
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar contacto", description = "Actualiza un contacto dado su ID")
    @ApiResponse(responseCode = "200", description = "Contacto actualizado exitosamente")
    @ApiResponse(responseCode = "404", description = "Contacto no encontrado")
    public Contact update(
        @PathVariable Integer id,
        @RequestBody Contact contact,
        @AuthenticationPrincipal UserDetails userDetails
    ) {
        String username = userDetails.getUsername();
        try {
            return contactsService.update(id, contact, username);
        } catch (Exception e) {
            throw new RuntimeException("Error al actualizar el contacto", e);
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar contacto por ID", description = "Retorna un contacto dado su ID")
    @ApiResponse(responseCode = "200", description = "Contacto encontrado")
    @ApiResponse(responseCode = "404", description = "Contacto no encontrado")
    public Contact getById(@PathVariable Integer id) {
        try {
            return contactsService.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener el contacto", e);
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar contacto", description = "Elimina un contacto dado su ID")
    @ApiResponse(responseCode = "200", description = "Contacto eliminado exitosamente")
    @ApiResponse(responseCode = "404", description = "Contacto no encontrado")
    public void delete(@PathVariable Integer id, @AuthenticationPrincipal UserDetails userDetails) {
        Contact exisContact = contactsService.findById(id);
        String username = userDetails.getUsername();
        User user = authService.getCurrentUser(username);
        Profile profile = user.getProfile();
        if (exisContact.getProfile().getId() != profile.getId())
            throw new RuntimeException("El contacto no pertenece al usuario actual");
        try {
            contactsService.delete(id);
        } catch (Exception e) {
            throw new RuntimeException("Error al eliminar el contacto", e);
        }
    }

}