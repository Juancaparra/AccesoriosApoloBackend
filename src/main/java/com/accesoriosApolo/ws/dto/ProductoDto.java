package com.accesoriosApolo.ws.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "PRODUCTO")
public class ProductoDto implements Serializable {
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

    @Column(name = "precio_unitario", precision = 10, scale = 2)
    private BigDecimal precioUnitario;

    @Column(name = "peso_unidad", precision = 10, scale = 2)
    private BigDecimal pesoUnidad;

    @Column(name = "ficha_tecnica", columnDefinition = "TEXT")
    private String fichaTecnica;

    @Column(name = "promo_descuento", precision = 5, scale = 2)
    private BigDecimal promoDescuento;

    @Column(name = "FK_id_categoria")
    private Integer fkIdCategoria;

    public ProductoDto() {
    }

    public ProductoDto(String referencia, String nombre, String descripcion, String talla, Integer stock,
                       BigDecimal precioUnitario, BigDecimal pesoUnidad, String fichaTecnica,
                       BigDecimal promoDescuento, Integer fkIdCategoria) {
        this.referencia = referencia;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.talla = talla;
        this.stock = stock;
        this.precioUnitario = precioUnitario;
        this.pesoUnidad = pesoUnidad;
        this.fichaTecnica = fichaTecnica;
        this.promoDescuento = promoDescuento;
        this.fkIdCategoria = fkIdCategoria;
    }

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

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public BigDecimal getPesoUnidad() {
        return pesoUnidad;
    }

    public void setPesoUnidad(BigDecimal pesoUnidad) {
        this.pesoUnidad = pesoUnidad;
    }

    public String getFichaTecnica() {
        return fichaTecnica;
    }

    public void setFichaTecnica(String fichaTecnica) {
        this.fichaTecnica = fichaTecnica;
    }

    public BigDecimal getPromoDescuento() {
        return promoDescuento;
    }

    public void setPromoDescuento(BigDecimal promoDescuento) {
        this.promoDescuento = promoDescuento;
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
                ", precioUnitario=" + precioUnitario +
                ", pesoUnidad=" + pesoUnidad +
                ", fichaTecnica='" + fichaTecnica + '\'' +
                ", promoDescuento=" + promoDescuento +
                ", fkIdCategoria=" + fkIdCategoria +
                '}';
    }
}
