package com.accesoriosApolo.ws.repository;

import com.accesoriosApolo.ws.Entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Usuario findByCedula(int cedula);

    // 🔐 Este método permite buscar por correo, clave para el login
    Optional<Usuario> findByCorreo(String correo); // ✅ Correcto
}
