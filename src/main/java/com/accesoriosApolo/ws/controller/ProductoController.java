package com.accesoriosApolo.ws.controller;

import com.accesoriosApolo.ws.Entidades.Producto;
import com.accesoriosApolo.ws.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicio/producto")
public class ProductoController {

    private final ProductoService productoService;

    @Autowired
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    // Obtener un producto por referencia
    @GetMapping("productos/{referencia}")
    public ResponseEntity<?> getProductoPorReferencia(@PathVariable("referencia") String referencia) {
        if (referencia == null || referencia.trim().isEmpty()) {
            return ResponseEntity.badRequest().body("El parámetro 'referencia' es obligatorio.");
        }

        Producto producto = productoService.obtenerProductoPorReferencia(referencia);

        if (producto == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Producto no encontrado para la referencia: " + referencia);
        }

        return ResponseEntity.ok(producto);
    }

    // Obtener lista de productos
    @GetMapping("productos-list")
    public ResponseEntity<List<Producto>> getProductos() {
        try {
            List<Producto> productos = productoService.obtenerListaProductos();

            if (productos.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }

            return ResponseEntity.ok(productos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    // Registrar un nuevo producto
    @PostMapping("registrar")
    public ResponseEntity<Producto> registrarProducto(@RequestBody Producto producto) {
        if (producto == null || producto.getReferencia() == null || producto.getReferencia().isEmpty()) {
            return ResponseEntity.badRequest().body(null);
        }

        Producto miProducto = productoService.registrarProducto(producto);

        if (miProducto != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(miProducto);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    // Actualizar un producto
    @PutMapping("actualizar")
    public ResponseEntity<?> actualizarProducto(@RequestBody Producto producto) {
        if (producto == null || producto.getReferencia() == null || producto.getReferencia().isEmpty()) {
            return ResponseEntity.badRequest().body("La referencia es obligatoria para actualizar un producto.");
        }

        Producto productoActualizado = productoService.actualizarProducto(producto);

        if (productoActualizado == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró un producto con la referencia especificada.");
        }

        return ResponseEntity.ok(productoActualizado);
    }

    // Eliminar un producto
    @DeleteMapping("eliminar/{referencia}")
    public ResponseEntity<?> eliminarProducto(@PathVariable String referencia) {
        if (referencia == null || referencia.isEmpty()) {
            return ResponseEntity.badRequest().body("La referencia es obligatoria para eliminar un producto.");
        }

        boolean eliminado = productoService.eliminarProducto(referencia);

        if (eliminado) {
            return ResponseEntity.ok("Producto eliminado exitosamente.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró un producto con la referencia especificada.");
        }
    }
}
