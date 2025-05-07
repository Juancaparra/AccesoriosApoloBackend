package com.accesoriosApolo.ws.repository;

import com.accesoriosApolo.ws.Entidades.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProveedorRepository extends JpaRepository<Proveedor, String> {
    Proveedor findByNit(String nit);
    Proveedor findByReferencia(String referencia);
    void deleteByReferencia(String referencia);
}
