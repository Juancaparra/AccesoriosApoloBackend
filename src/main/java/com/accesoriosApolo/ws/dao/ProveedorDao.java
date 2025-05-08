package com.accesoriosApolo.ws.dao;

import com.accesoriosApolo.ws.Entidades.Proveedor;
import com.accesoriosApolo.ws.repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProveedorDao {

    @Autowired
    private ProveedorRepository proveedorRepository;

    // Buscar un proveedor por su NIT
    public Proveedor consultarProveedorIndividual(String nit) {
        return proveedorRepository.findByNit(nit);
    }

    // Obtener la lista de proveedores
    public List<Proveedor> obtenerListaProveedores() {
        return proveedorRepository.findAll();
    }

    // Registrar un proveedor
    public Proveedor registrarProveedor(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    // Actualizar un proveedor
    public Proveedor actualizarProveedor(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    // Eliminar un proveedor por su NIT
    public boolean eliminarProveedor(String nit) {
        try {
            proveedorRepository.deleteByNit(nit);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
