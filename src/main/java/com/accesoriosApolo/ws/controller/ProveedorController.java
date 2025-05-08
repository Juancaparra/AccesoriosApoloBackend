package com.accesoriosApolo.ws.controller;

import com.accesoriosApolo.ws.Entidades.Proveedor;
import com.accesoriosApolo.ws.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicio/proveedor")
public class ProveedorController {

    private final ProveedorService proveedorService;

    @Autowired
    public ProveedorController(ProveedorService proveedorService) {
        this.proveedorService = proveedorService;
    }

    @GetMapping("/proveedor/{nit}")
    public ResponseEntity<?> getProveedorPorNit(@PathVariable String nit) {
        if (nit == null || nit.trim().isEmpty()) {
            return ResponseEntity.badRequest().body("El parámetro 'nit' es obligatorio");
        }
        Proveedor proveedor = proveedorService.obtenerProveedorPorNit(nit);
        if (proveedor == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Proveedor no encontrado con el NIT: " + nit);
        }
        return ResponseEntity.ok(proveedor);
    }

    @GetMapping("/proveedor-list")
    public ResponseEntity<List<Proveedor>> getProveedores() {
        try {
            List<Proveedor> proveedors = proveedorService.obtenerListaProveedor();
            if (proveedors.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }
            return ResponseEntity.ok(proveedors);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/nombre")
    public ResponseEntity<Proveedor> registrarProveedor(@RequestBody Proveedor proveedor) {
        Proveedor nuevoProveedor = proveedorService.registrarProveedor(proveedor);
        if (nuevoProveedor != null) {
            return ResponseEntity.ok(nuevoProveedor);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/actualizar")
    public ResponseEntity<?> actualizarProveedor(@RequestBody Proveedor proveedor) {
        Proveedor proveedorActualizado = proveedorService.actualizarProveedor(proveedor);
        if (proveedorActualizado == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontró un proveedor con el NIT especificado");
        }
        return ResponseEntity.ok(proveedorActualizado);
    }

    @DeleteMapping("/eliminar/{nit}")
    public ResponseEntity<?> eliminarProveedor(@PathVariable String nit) {
        if (nit == null || nit.isEmpty()) {
            return ResponseEntity.badRequest().body("El NIT es obligatorio para eliminar");
        }
        boolean eliminado = proveedorService.eliminarProveedor(nit);
        if (eliminado) {
            return ResponseEntity.ok("Proveedor eliminado exitosamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontró un proveedor con el NIT especificado");
        }
    }
}
