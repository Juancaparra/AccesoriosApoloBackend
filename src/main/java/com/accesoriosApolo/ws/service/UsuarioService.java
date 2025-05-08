package com.accesoriosApolo.ws.service;

import com.accesoriosApolo.ws.Entidades.Usuario;
import com.accesoriosApolo.ws.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public void actualizarContrasenas() {
        for (Usuario usuario : usuarioRepository.findAll()) {
            if (!usuario.getContrasena().startsWith("{bcrypt}")) {
                usuario.setContrasena(passwordEncoder.encode(usuario.getContrasena()));
                usuarioRepository.save(usuario);
            }
        }
    }

    // Obtener un usuario por su cédula
    public Usuario obtenerUsuarioPorCedula(int cedula) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(cedula);
        return usuarioOptional.orElse(null); // Devuelve null si no encuentra el usuario
    }

    // Obtener la lista de todos los usuarios
    public List<Usuario> obtenerListaUsuarios() {
        return usuarioRepository.findAll();
    }

    // Registrar un nuevo usuario
    public Usuario registrarUsuario(Usuario usuario) {
        // Aquí podrías agregar validaciones adicionales antes de guardar
        if (usuario.getContrasena() != null) {
            usuario.setContrasena(passwordEncoder.encode(usuario.getContrasena())); // Encriptar la contraseña
        }
        return usuarioRepository.save(usuario); // Guardar el usuario en la base de datos
    }

    // Actualizar un usuario existente
    public Usuario actualizarUsuario(Usuario usuario) {
        // Verificar si el usuario existe antes de intentar actualizarlo
        if (usuarioRepository.existsById(usuario.getCedula())) {
            if (usuario.getContrasena() != null) {
                usuario.setContrasena(passwordEncoder.encode(usuario.getContrasena())); // Encriptar la nueva contraseña
            }
            return usuarioRepository.save(usuario); // Guardar los cambios del usuario
        }
        return null; // Si el usuario no existe, devolver null
    }

    // Eliminar un usuario por su cédula
    public boolean eliminarUsuario(int cedula) {
        if (usuarioRepository.existsById(cedula)) {
            usuarioRepository.deleteById(cedula);
            return true; // Usuario eliminado correctamente
        }
        return false; // Usuario no encontrado para eliminar
    }
}
