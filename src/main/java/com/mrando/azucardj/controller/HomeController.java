package com.mrando.azucardj.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
public class HomeController {

  @Autowired
  private PasswordEncoder passwordEncoder;

  @GetMapping("/")
  public String Home() {
      return "hola";
  }

  @GetMapping("/bcrypt/{text}")
  @ResponseBody
  public String Encoder(@PathVariable("text") String text) {
    return text + " Encriptado en Bcrypt: " + passwordEncoder.encode(text);
  }

}
