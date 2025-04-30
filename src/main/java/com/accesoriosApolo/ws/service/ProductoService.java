package com.accesoriosApolo.ws.service;

import com.accesoriosApolo.ws.dao.ProductoDao;
import com.accesoriosApolo.ws.dto.ProductoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    private final ProductoDao productoDao;

    @Autowired
    public ProductoService(ProductoDao productoDao) {
        this.productoDao = productoDao;
    }

    public ProductoDto obtenerProductoPorReferencia(String referencia) {
        return productoDao.consultarProductoIndividual(referencia);
    }

    public List<ProductoDto> obtenerListaProductos() {
        return productoDao.obtenerListaProductos();
    }

    public ProductoDto registrarProducto(ProductoDto productoDto) {
        if (productoDto == null || productoDto.getReferencia() == null || productoDto.getReferencia().isEmpty()) {
            return null;
        }
        return productoDao.registrarProducto(productoDto);
    }

    public ProductoDto actualizarProducto(ProductoDto productoDto) {
        if (productoDto == null || productoDto.getReferencia() == null || productoDto.getReferencia().isEmpty()) {
            return null;
        }

        ProductoDto productoExistente = productoDao.consultarProductoIndividual(productoDto.getReferencia());
        if (productoExistente == null) {
            return null;
        }

        return productoDao.actualizarProducto(productoDto);
    }

    public boolean eliminarProducto(String referencia) {
        ProductoDto productoExistente = productoDao.consultarProductoIndividual(referencia);
        if (productoExistente == null) {
            return false;
        }
        return productoDao.eliminarProducto(productoExistente);
    }
}
