package com.accesoriosApolo.ws.controller;

import com.accesoriosApolo.ws.dto.ProductoDto;
import com.accesoriosApolo.ws.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicio")
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

        ProductoDto productoDto = productoService.obtenerProdutoPorReferencia(referencia);

        if (productoDto == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Producto no encontrado para la referencia: " + referencia);
        }

        return ResponseEntity.ok(productoDto);
    }

    // Obtener lista de productos
    @GetMapping("productos-list")
    public ResponseEntity<List<ProductoDto>> getProductos() {
        try {
            List<ProductoDto> productoDtos = productoService.obtenerListaProductos();

            if (productoDtos.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }

            return ResponseEntity.ok(productoDtos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    // Registrar un nuevo producto
    @PostMapping("registrar")
    public ResponseEntity<ProductoDto> registrarProducto(@RequestBody ProductoDto productoDto) {
        if (productoDto == null || productoDto.getReferencia() == null || productoDto.getReferencia().isEmpty()) {
            return ResponseEntity.badRequest().body(null);
        }

        ProductoDto miProducto = productoService.registrarProducto(productoDto);

        if (miProducto != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(miProducto);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    // Actualizar un producto
    @PutMapping("actualizar")
    public ResponseEntity<?> actualizarProducto(@RequestBody ProductoDto productoDto) {
        if (productoDto == null || productoDto.getReferencia() == null || productoDto.getReferencia().isEmpty()) {
            return ResponseEntity.badRequest().body("La referencia es obligatoria para actualizar un producto.");
        }

        ProductoDto productoActualizado = productoService.actualizarProducto(productoDto);

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
