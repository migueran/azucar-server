package com.mrando.azucardj.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@Tag(name = "Home", description = "Endpoints de bienvenida y utilidades")
public class HomeController {

  @Autowired
  private PasswordEncoder passwordEncoder;

  @GetMapping("/")
  @Operation(summary = "Bienvenida", description = "Endpoint raíz de la API")
  @ApiResponse(responseCode = "200", description = "API disponible")
  public String Home() {
      return "Azucar Dj";
  }

  @GetMapping("/bcrypt/{text}")
  @ResponseBody
  @Operation(summary = "Encriptar texto", description = "Retorna el texto encriptado en BCrypt")
  @ApiResponse(responseCode = "200", description = "Texto encriptado exitosamente")
  public String Encoder(@PathVariable("text") String text) {
    try {
      return text + " Encriptado en Bcrypt: " + passwordEncoder.encode(text);
    } catch (ResponseStatusException e) {
      throw e;
    }
  }

}
