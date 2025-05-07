package com.accesoriosApolo.ws.Entidades;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "producto") // Asegúrate de que este nombre coincide con tu tabla
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "referencia", length = 50)
    private String referencia;

    @Column(name = "nombre", length = 100)
    private String nombre;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "talla", length = 10)
    private String talla;

    @Column(name = "stock")
    private Integer stock;

    @Column(name = "url_archivo", columnDefinition = "TEXT")
    private String urlArchivo;

    @Column(name = "precio_unidad", precision = 10, scale = 2)
    private BigDecimal precioUnidad;

    @Column(name = "ficha_tecnica", columnDefinition = "TEXT")
    private String fichaTecnica;

    @Column(name = "precio_descuento", precision = 10, scale = 2)
    private BigDecimal precioDescuento;

    @Column(name = "fk_id_categoria")
    private Integer fkIdCategoria;

    public Producto() {
    }

    public Producto(String referencia, String nombre, String descripcion, String talla, Integer stock,
                    String urlArchivo, BigDecimal precioUnidad, String fichaTecnica,
                    BigDecimal precioDescuento, Integer fkIdCategoria) {
        this.referencia = referencia;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.talla = talla;
        this.stock = stock;
        this.urlArchivo = urlArchivo;
        this.precioUnidad = precioUnidad;
        this.fichaTecnica = fichaTecnica;
        this.precioDescuento = precioDescuento;
        this.fkIdCategoria = fkIdCategoria;
    }

    // Getters y Setters

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getUrlArchivo() {
        return urlArchivo;
    }

    public void setUrlArchivo(String urlArchivo) {
        this.urlArchivo = urlArchivo;
    }

    public BigDecimal getPrecioUnidad() {
        return precioUnidad;
    }

    public void setPrecioUnidad(BigDecimal precioUnidad) {
        this.precioUnidad = precioUnidad;
    }

    public String getFichaTecnica() {
        return fichaTecnica;
    }

    public void setFichaTecnica(String fichaTecnica) {
        this.fichaTecnica = fichaTecnica;
    }

    public BigDecimal getPrecioDescuento() {
        return precioDescuento;
    }

    public void setPrecioDescuento(BigDecimal precioDescuento) {
        this.precioDescuento = precioDescuento;
    }

    public Integer getFkIdCategoria() {
        return fkIdCategoria;
    }

    public void setFkIdCategoria(Integer fkIdCategoria) {
        this.fkIdCategoria = fkIdCategoria;
    }

    @Override
    public String toString() {
        return "ProductoDto{" +
                "referencia='" + referencia + '\'' +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", talla='" + talla + '\'' +
                ", stock=" + stock +
                ", urlArchivo='" + urlArchivo + '\'' +
                ", precioUnidad=" + precioUnidad +
                ", fichaTecnica='" + fichaTecnica + '\'' +
                ", precioDescuento=" + precioDescuento +
                ", fkIdCategoria=" + fkIdCategoria +
                '}';
    }
}
