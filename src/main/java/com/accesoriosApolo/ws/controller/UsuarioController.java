package com.accesoriosApolo.ws.controller;

import com.accesoriosApolo.ws.Entidades.Usuario;
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
        Usuario usuario = usuarioService.obtenerUsuarioPorCedula(cedula);
        if (usuario == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Usuario no encontrado para la cédula: " + cedula);
        }
        return ResponseEntity.ok(usuario);
    }

    @GetMapping("/usuarios-list")
    public ResponseEntity<List<Usuario>> getUsuarios() {
        try {
            List<Usuario> usuarios = usuarioService.obtenerListaUsuarios();

            if (usuarios.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }

            return ResponseEntity.ok(usuarios);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }

    @PostMapping("/registrar-usuario")
    public ResponseEntity<Usuario> registrarUsuario(@RequestBody Usuario usuario) {

        Usuario miUsuario = usuarioService.registrarUsuario(usuario);

        if (miUsuario != null) {
            return ResponseEntity.ok(miUsuario);
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @PutMapping("/actualizar-usuario")
    public ResponseEntity<?> actualizarUsuario(@RequestBody Usuario usuario) {
        Usuario usuarioActualizado = usuarioService.actualizarUsuario(usuario);

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
