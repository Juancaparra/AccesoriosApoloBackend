package com.accesoriosApolo.ws.repository;

import com.accesoriosApolo.ws.Entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByCedula(int cedula);
}
