package com.mrando.azucardj.auth;

import com.mrando.azucardj.model.User;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

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

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        AuthResponse response = authService.login(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/register")
    @Operation(summary = "Crear usuario", description = "Registra un nuevo usuario")
    @ApiResponse(responseCode = "200", description = "Usuario creado exitosamente")
    public ResponseEntity<User> register(@RequestBody User user) {
        try {
            User created = authService.register(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(created);
        } catch (ResponseStatusException e) {
            throw e;
        }
    }
}
