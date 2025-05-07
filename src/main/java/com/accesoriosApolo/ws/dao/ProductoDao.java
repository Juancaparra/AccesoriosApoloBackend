package com.accesoriosApolo.ws.dao;

import com.accesoriosApolo.ws.Entidades.Producto;
import com.accesoriosApolo.ws.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoDao {

    private final ProductoRepository productoRepository;

    @Autowired
    public ProductoDao(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    // Consultar producto por referencia
    public Producto consultarProductoIndividual(String referencia) {
        Optional<Producto> producto = productoRepository.findById(referencia);
        return producto.orElse(null);
    }

    // Obtener lista de productos
    public List<Producto> obtenerListaProductos() {
        return productoRepository.findAll();
    }

    // Registrar producto
    public Producto registrarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    // Actualizar producto
    public Producto actualizarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    // Eliminar producto
    public boolean eliminarProducto(Producto producto) {
        Optional<Producto> productoExistente = productoRepository.findById(producto.getReferencia());
        if (productoExistente.isPresent()) {
            productoRepository.delete(productoExistente.get());
            return true;
        }
        return false;
    }
}
