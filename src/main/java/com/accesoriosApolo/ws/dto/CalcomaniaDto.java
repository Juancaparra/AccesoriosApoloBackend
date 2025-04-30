package com.accesoriosApolo.ws.dto;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "CALCOMANIA")
public class CalcomaniaDto implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_calcomania")
    private Integer idCalcomania;

    @Column(name = "nombre", length = 100)
    private String nombre;

    @Column(name = "formato", length = 50)
    private String formato;

    @Column(name = "formato_archivo", length = 50)
    private String formatoArchivo;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_subida")
    private Date fechaSubida;

    @Column(name = "url_repositorio", columnDefinition = "TEXT")
    private String urlRepositorio;

    @Column(name = "FK_cedula")
    private Integer fkCedula;

    public CalcomaniaDto() {
    }

    public CalcomaniaDto(Integer idCalcomania, String nombre, String formato, String formatoArchivo,
                         Date fechaSubida, String urlRepositorio, Integer fkCedula) {
        this.idCalcomania = idCalcomania;
        this.nombre = nombre;
        this.formato = formato;
        this.formatoArchivo = formatoArchivo;
        this.fechaSubida = fechaSubida;
        this.urlRepositorio = urlRepositorio;
        this.fkCedula = fkCedula;
    }

    public Integer getIdCalcomania() {
        return idCalcomania;
    }

    public void setIdCalcomania(Integer idCalcomania) {
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

    public String getFormatoArchivo() {
        return formatoArchivo;
    }

    public void setFormatoArchivo(String formatoArchivo) {
        this.formatoArchivo = formatoArchivo;
    }

    public Date getFechaSubida() {
        return fechaSubida;
    }

    public void setFechaSubida(Date fechaSubida) {
        this.fechaSubida = fechaSubida;
    }

    public String getUrlRepositorio() {
        return urlRepositorio;
    }

    public void setUrlRepositorio(String urlRepositorio) {
        this.urlRepositorio = urlRepositorio;
    }

    public Integer getFkCedula() {
        return fkCedula;
    }

    public void setFkCedula(Integer fkCedula) {
        this.fkCedula = fkCedula;
    }

    @Override
    public String toString() {
        return "CalcomaniaDto{" +
                "idCalcomania=" + idCalcomania +
                ", nombre='" + nombre + '\'' +
                ", formato='" + formato + '\'' +
                ", formatoArchivo='" + formatoArchivo + '\'' +
                ", fechaSubida=" + fechaSubida +
                ", urlRepositorio='" + urlRepositorio + '\'' +
                ", fkCedula=" + fkCedula +
                '}';
    }
}
