package com.accesoriosApolo.ws.controller;

import com.accesoriosApolo.ws.dto.AuthRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final SeguridadConfig seguridadConfig;

    public AuthController(SeguridadConfig seguridadConfig) {
        this.seguridadConfig = seguridadConfig;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthRequest authRequest) {
        // Validar credenciales (esto es solo un ejemplo, deberías validar con tu base de datos)
        if ("admin".equals(authRequest.getCorreo()) && "adminPass".equals(authRequest.getContrasena())) {
            // Generar el token JWT utilizando el correo del usuario como payload
            String token = seguridadConfig.generateToken(authRequest.getCorreo());
            return ResponseEntity.ok(token);  // Retorna el token JWT generado
        }
        return ResponseEntity.status(401).body("Credenciales inválidas");
    }
}
