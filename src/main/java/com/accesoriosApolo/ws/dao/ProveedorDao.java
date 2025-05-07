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

    public Proveedor consultarProveedorIndividual(String nit) {
        return proveedorRepository.findByNit(nit);
    }

    public List<Proveedor> obtenerListaProveedores() {
        return proveedorRepository.findAll();
    }

    public Proveedor registrarProveedor(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    public Proveedor actualizarProveedor(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    public boolean eliminarProveedor(Proveedor proveedor) {
        try {
            proveedorRepository.delete(proveedor);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Métodos antiguos (basados en referencia, si los necesitas)
    public Proveedor obtenerProveedor(String referencia) {
        return proveedorRepository.findByReferencia(referencia);
    }

    public void eliminarProveedor(String referencia) {
        proveedorRepository.deleteByReferencia(referencia);
    }
}
