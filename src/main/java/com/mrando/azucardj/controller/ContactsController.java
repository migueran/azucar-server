package com.mrando.azucardj.controller;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.mrando.azucardj.model.Contact;
import com.mrando.azucardj.service.ContactsService;

@RestController
@RequestMapping("/contacts")
@Tag(name = "Contacts", description = "Gestión de contactos de perfil")
public class ContactsController {

    @Autowired
    private ContactsService contactsService;

    @GetMapping
    @Operation(summary = "Listar contactos", description = "Retorna todos los contactos registrados")
    @ApiResponse(responseCode = "200", description = "Lista de contactos obtenida exitosamente")
    public List<Contact> fetch() {
        return contactsService.fetch();
    }

    @PostMapping
    @Operation(summary = "Crear contacto", description = "Registra un nuevo contacto de perfil")
    @ApiResponse(responseCode = "200", description = "Contacto creado exitosamente")
    public void save(@RequestBody Contact contact) {
        contactsService.save(contact);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar contacto", description = "Actualiza un contacto dado su ID")
    @ApiResponse(responseCode = "200", description = "Contacto actualizado exitosamente")
    @ApiResponse(responseCode = "404", description = "Contacto no encontrado")
    public Contact update(@PathVariable Integer id, @RequestBody Contact contact) {
        return contactsService.update(id, contact);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar contacto por ID", description = "Retorna un contacto dado su ID")
    @ApiResponse(responseCode = "200", description = "Contacto encontrado")
    @ApiResponse(responseCode = "404", description = "Contacto no encontrado")
    public Contact getById(@PathVariable Integer id) {
        return contactsService.findById(id);
    }

}