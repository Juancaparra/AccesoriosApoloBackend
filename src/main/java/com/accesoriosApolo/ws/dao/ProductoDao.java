package com.accesoriosApolo.ws.dao;

import com.accesoriosApolo.ws.dto.ProductoDto;
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
    public ProductoDto consultarProductoIndividual(String referencia) {
        Optional<ProductoDto> producto = productoRepository.findById(referencia);
        return producto.orElse(null);
    }

    // Obtener lista de productos
    public List<ProductoDto> obtenerListaProductos() {
        return productoRepository.findAll();
    }

    // Registrar producto
    public ProductoDto registrarProducto(ProductoDto productoDto) {
        return productoRepository.save(productoDto);
    }

    // Actualizar producto
    public ProductoDto actualizarProducto(ProductoDto productoDto) {
        return productoRepository.save(productoDto);
    }

    // Eliminar producto
    public boolean eliminarProducto(ProductoDto productoDto) {
        Optional<ProductoDto> productoExistente = productoRepository.findById(productoDto.getReferencia());
        if (productoExistente.isPresent()) {
            productoRepository.delete(productoExistente.get());
            return true;
        }
        return false;
    }
}
