package com.accesoriosApolo.ws.controller;

import com.accesoriosApolo.ws.dto.UsuarioDto;
import com.accesoriosApolo.ws.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicio")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/usuarios/{cedula}")
    public ResponseEntity<?> getUsuarioCedula(@PathVariable("cedula") int cedula) {
        if (cedula <= 0) {
            return ResponseEntity.badRequest().body("El parámetro 'cedula' es obligatorio y debe ser mayor que 0.");
        }
        UsuarioDto usuarioDto = usuarioService.obtenerUsuarioPorCedula(cedula);
        if (usuarioDto == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Usuario no encontrado para la cédula: " + cedula);
        }
        return ResponseEntity.ok(usuarioDto);
    }

    @GetMapping("/usuarios-list")
    public ResponseEntity<List<UsuarioDto>> getUsuarios() {
        try {
            List<UsuarioDto> usuarioDtos = usuarioService.obtenerListaUsuarios();

            if (usuarioDtos.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }

            return ResponseEntity.ok(usuarioDtos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }

    @PostMapping("/registrar-usuario")
    public ResponseEntity<UsuarioDto> registrarUsuario(@RequestBody UsuarioDto usuarioDto) {

        UsuarioDto miUsuario = usuarioService.registrarUsuario(usuarioDto);

        if (miUsuario != null) {
            return ResponseEntity.ok(miUsuario);
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @PutMapping("/actualizar-usuario")
    public ResponseEntity<?> actualizarUsuario(@RequestBody UsuarioDto usuarioDto) {
        UsuarioDto usuarioActualizado = usuarioService.actualizarUsuario(usuarioDto);

        if (usuarioActualizado == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró un usuario con la cédula especificada.");
        }
        return ResponseEntity.ok(usuarioActualizado);
    }

    @DeleteMapping("/eliminar-usuario/{cedula}")
    public ResponseEntity<?> eliminarUsuario(@PathVariable int cedula) {
        if (cedula <= 0) {
            return ResponseEntity.badRequest().body("La cédula es obligatoria para eliminar un usuario.");
        }
        boolean eliminado = usuarioService.eliminarUsuario(cedula);
        if (eliminado) {
            return ResponseEntity.ok("Usuario eliminado exitosamente.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró un usuario con la cédula especificada.");
        }
    }
}
