package com.accesoriosApolo.ws.dao;

import com.accesoriosApolo.ws.dto.ProductoDto;
import com.accesoriosApolo.ws.util.ProductoUtilidades;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductoDao {

    public ProductoDao() {
        ProductoUtilidades.iniciarLista();
    }

    public ProductoDto consultarProductoIndividual(String referencia) {
        for (ProductoDto p : ProductoUtilidades.listaProductos) {
            if (p.getReferencia().equals(referencia)) {
                return new ProductoDto(
                        p.getReferencia(),
                        p.getNombre(),
                        p.getDescripcion(),
                        p.getTalla(),
                        p.getStock(),
                        p.getUrlArchivo(),
                        p.getPrecioUnidad(),
                        p.getFichaTecnica(),
                        p.getPrecioDescuento(),
                        p.getFkIdCategoria()
                );
            }
        }
        return null;
    }

    public List<ProductoDto> obtenerListaProductos() {
        return ProductoUtilidades.listaProductos;
    }

    public ProductoDto registrarProducto(ProductoDto productoDto) {
        for (ProductoDto obj : ProductoUtilidades.listaProductos) {
            if (obj.getReferencia().equals(productoDto.getReferencia())) {
                return null; // Ya existe
            }
        }
        ProductoUtilidades.listaProductos.add(productoDto);
        return productoDto;
    }

    public ProductoDto actualizarProducto(ProductoDto productoDto) {
        for (ProductoDto obj : ProductoUtilidades.listaProductos) {
            if (obj.getReferencia().equals(productoDto.getReferencia())) {
                obj.setNombre(productoDto.getNombre());
                obj.setDescripcion(productoDto.getDescripcion());
                obj.setTalla(productoDto.getTalla());
                obj.setStock(productoDto.getStock());
                obj.setUrlArchivo(productoDto.getUrlArchivo());
                obj.setPrecioUnidad(productoDto.getPrecioUnidad());
                obj.setFichaTecnica(productoDto.getFichaTecnica());
                obj.setPrecioDescuento(productoDto.getPrecioDescuento());
                obj.setFkIdCategoria(productoDto.getFkIdCategoria());
                return obj;
            }
        }
        return null;
    }

    public boolean eliminarProducto(ProductoDto productoDto) {
        return ProductoUtilidades.listaProductos.removeIf(p -> p.getReferencia().equals(productoDto.getReferencia()));
    }
}
