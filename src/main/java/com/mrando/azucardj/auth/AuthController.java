package com.mrando.azucardj.auth;

import com.mrando.azucardj.model.Contact;
// import com.mrando.azucardj.model.Network;
import com.mrando.azucardj.model.Profile;
import com.mrando.azucardj.model.Role;
import com.mrando.azucardj.model.User;
import com.mrando.azucardj.service.ContactsService;
import com.mrando.azucardj.service.NetworksService;
import com.mrando.azucardj.service.ProfilesService;
import com.mrando.azucardj.service.RolesService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final NetworksService networksService;
    private final ContactsService contactsService;
    private final ProfilesService profilesService;
    private final AuthService authService;
    private final RolesService rolesService;

    public AuthController(
        AuthService authService,
        ProfilesService profilesService,
        ContactsService contactsService,
        RolesService rolesService, NetworksService networksService
    ) {
        this.authService = authService;
        this.profilesService = profilesService;
        this.contactsService = contactsService;
        this.rolesService = rolesService;
        this.networksService = networksService;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        AuthResponse response = authService.login(request);
        return ResponseEntity.ok(response);
    }

    // @PostMapping("/logout")
    // public ResponseEntity<Void> logout() {
    //     authService.logout();
    //     return ResponseEntity.ok().build();
    // }

    @PostMapping("/register")
    @Operation(summary = "Crear usuario", description = "Registra un nuevo usuario")
    @ApiResponse(responseCode = "200", description = "Usuario creado exitosamente")
    public ResponseEntity<User> register(@RequestBody User user) {
        try {
            List<Role> roleList = user.getRole();
            roleList.forEach(role -> {
                if (rolesService.findById(role.getId()) == null) {
                    throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, "El rol no existe"
                    );
                }
            });
            Profile profile = user.getProfile();
            List<Contact> contactList = profile.getContact();
            contactList.forEach(contact -> {
                if ( networksService.findById(
                    contact.getNetwork().getId()) == null
                ) {
                    throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, "La red no existe"
                    );
                }
            });
            profilesService.save(profile);
            contactList.forEach(contact -> {
                contact.setProfile(profile);
                contactsService.save(contact, user.getUsername());
            });
            User created = authService.register(user);
            System.err.println("created: " + created);
            return ResponseEntity.status(HttpStatus.CREATED).body(created);
        } catch (ResponseStatusException e) {
            throw e;
        }
    }
}
