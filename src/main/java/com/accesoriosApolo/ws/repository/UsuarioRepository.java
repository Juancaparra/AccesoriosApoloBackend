package com.accesoriosApolo.ws.repository;

import com.accesoriosApolo.ws.dto.UsuarioDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioDto, Long> {
    UsuarioDto findByCedula(int cedula);
}
