package com.accesoriosApolo.ws.repository;

import com.accesoriosApolo.ws.Entidades.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProveedorRepository extends JpaRepository<Proveedor, String> {

    // Método para encontrar por Nit (único)
    Proveedor findByNit(String nit);

    // Eliminar por Nit (único)
    void deleteByNit(String nit);
}
