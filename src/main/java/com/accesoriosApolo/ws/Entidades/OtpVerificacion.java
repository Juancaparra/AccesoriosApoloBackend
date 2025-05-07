package com.accesoriosApolo.ws.Entidades;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "otp_verificacion")
public class OtpVerificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String correo;

    private String codigo;

    private LocalDateTime fechaExpiracion;

    public OtpVerificacion(Long id, String correo, String codigo, LocalDateTime fechaExpiracion) {
        this.id = id;
        this.correo = correo;
        this.codigo = codigo;
        this.fechaExpiracion = fechaExpiracion;
    }

    public OtpVerificacion() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public LocalDateTime getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(LocalDateTime fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }
}
