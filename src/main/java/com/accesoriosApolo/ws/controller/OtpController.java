package com.accesoriosApolo.ws.controller;

import com.accesoriosApolo.ws.Entidades.Usuario;
import com.accesoriosApolo.ws.repository.UsuarioRepository;
import com.accesoriosApolo.ws.service.OtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/otp")
public class OtpController {

    @Autowired
    private OtpService otpService;

    @Autowired
    private UsuarioRepository usuarioRepo;

    // Paso 1: Enviar OTP al correo
    @PostMapping("/enviar")
    public ResponseEntity<String> enviar(@RequestBody Map<String, String> request) {
        String correo = request.get("correo");
        otpService.enviarOtp(correo);
        return ResponseEntity.ok("OTP enviado al correo.");
    }

    // Paso 2: Verificar OTP y crear usuario
    @PostMapping("/verificar")
    public ResponseEntity<?> verificar(@RequestBody Map<String, String> request) {
        String correo = request.get("correo");
        String codigo = request.get("codigo");

        if (!otpService.verificarOtp(correo, codigo)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Código incorrecto o expirado");
        }

        // Crear usuario
        Usuario usuario = new Usuario();
        usuario.setCorreo(correo);
        usuario.setNombre(request.get("nombre"));
        usuario.setTelefono(request.get("telefono"));
        usuario.setContrasena(request.get("contrasena")); // cifrar en producción
        usuarioRepo.save(usuario);

        return ResponseEntity.ok("Usuario registrado y verificado correctamente");
    }
}

