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

    // Obtener producto por referencia
    public ProductoDto obtenerProdutoPorReferencia(String referencia) {
        return productoDao.consultarProductoIndividual(referencia); // Mantener el método original
    }

    // Obtener lista de productos
    public List<ProductoDto> obtenerListaProductos() {
        return productoDao.obtenerListaProductos(); // Mantener el método original
    }

    // Registrar un nuevo producto
    public ProductoDto registrarProducto(ProductoDto productoDto) {
        if (productoDto == null || productoDto.getReferencia() == null || productoDto.getReferencia().isEmpty()) {
            return null;
        }

        // Verificar si el producto ya existe con el método de tu Dao
        ProductoDto productoExistente = productoDao.consultarProductoIndividual(productoDto.getReferencia());
        if (productoExistente != null) {
            return null; // El producto ya existe
        }

        return productoDao.registrarProducto(productoDto); // Usar el método original para registrar el producto
    }

    // Actualizar un producto
    public ProductoDto actualizarProducto(ProductoDto productoDto) {
        if (productoDto == null || productoDto.getReferencia() == null || productoDto.getReferencia().isEmpty()) {
            return null;
        }

        // Verificar si el producto existe con el método de tu Dao
        ProductoDto productoExistente = productoDao.consultarProductoIndividual(productoDto.getReferencia());
        if (productoExistente == null) {
            return null; // Producto no encontrado, no se puede actualizar
        }

        return productoDao.actualizarProducto(productoDto); // Usar el método original para actualizar el producto
    }

    // Eliminar un producto
    public boolean eliminarProducto(String referencia) {
        ProductoDto productoExistente = productoDao.consultarProductoIndividual(referencia); // Consultar el producto con el método de tu Dao
        if (productoExistente == null) {
            return false; // Producto no encontrado
        }

        return productoDao.eliminarProducto(productoExistente); // Usar el método original para eliminar el producto
    }
}
