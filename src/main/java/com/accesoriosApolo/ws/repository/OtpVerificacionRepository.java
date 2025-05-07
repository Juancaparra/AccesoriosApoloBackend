package com.accesoriosApolo.ws.repository;

import com.accesoriosApolo.ws.Entidades.OtpVerificacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OtpVerificacionRepository extends JpaRepository<OtpVerificacion, Long> {
    Optional<OtpVerificacion> findByCorreoAndCodigo(String correo, String codigo);
    void deleteByCorreo(String correo);
}

