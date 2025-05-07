package com.accesoriosApolo.ws.Entidades;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "CALCOMANIA")
public class Calcomania implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_calcomania")
    private Long idCalcomania;

    @Column(name = "nombre", length = 100)
    private String nombre;

    @Column(name = "formato", length = 50)
    private String formato;

    @Column(name = "tamaño_archivo", length = 50)
    private String tamañoArchivo;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_subida")
    private Date fechaSubida;

    @Column(name = "url_archivo", columnDefinition = "TEXT")
    private String urlArchivo;

    @Column(name = "FK_cedula")
    private Long fkCedula;

    public Calcomania() {
    }

    public Calcomania(Long idCalcomania, String nombre, String formato, String tamañoArchivo,
                      Date fechaSubida, String urlArchivo, Long fkCedula) {
        this.idCalcomania = idCalcomania;
        this.nombre = nombre;
        this.formato = formato;
        this.tamañoArchivo = tamañoArchivo;
        this.fechaSubida = fechaSubida;
        this.urlArchivo = urlArchivo;
        this.fkCedula = fkCedula;
    }

    public Long getIdCalcomania() {
        return idCalcomania;
    }

    public void setIdCalcomania(Long idCalcomania) {
        this.idCalcomania = idCalcomania;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public String getTamañoArchivo() {
        return tamañoArchivo;
    }

    public void setTamañoArchivo(String tamañoArchivo) {
        this.tamañoArchivo = tamañoArchivo;
    }

    public Date getFechaSubida() {
        return fechaSubida;
    }

    public void setFechaSubida(Date fechaSubida) {
        this.fechaSubida = fechaSubida;
    }

    public String getUrlArchivo() {
        return urlArchivo;
    }

    public void setUrlArchivo(String urlArchivo) {
        this.urlArchivo = urlArchivo;
    }

    public Long getFkCedula() {
        return fkCedula;
    }

    public void setFkCedula(Long fkCedula) {
        this.fkCedula = fkCedula;
    }

    @Override
    public String toString() {
        return "CalcomaniaDto{" +
                "idCalcomania=" + idCalcomania +
                ", nombre='" + nombre + '\'' +
                ", formato='" + formato + '\'' +
                ", tamañoArchivo='" + tamañoArchivo + '\'' +
                ", fechaSubida=" + fechaSubida +
                ", urlArchivo='" + urlArchivo + '\'' +
                ", fkCedula=" + fkCedula +
                '}';
    }
}
