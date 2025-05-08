package com.accesoriosApolo.ws.service;

import com.accesoriosApolo.ws.dao.ProveedorDao;
import com.accesoriosApolo.ws.Entidades.Proveedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorService {

    private final ProveedorDao proveedorDao;

    @Autowired
    public ProveedorService(ProveedorDao proveedorDao) {
        this.proveedorDao = proveedorDao;
    }

    // Obtener un proveedor por NIT
    public Proveedor obtenerProveedorPorNit(String nit) {
        return proveedorDao.consultarProveedorIndividual(nit);
    }

    // Obtener lista de proveedores
    public List<Proveedor> obtenerListaProveedor() {
        return proveedorDao.obtenerListaProveedores();
    }

    // Registrar un proveedor
    public Proveedor registrarProveedor(Proveedor proveedor) {
        if (proveedor == null || proveedor.getNit() == null || proveedor.getNit().isEmpty()) {
            return null;
        }
        return proveedorDao.registrarProveedor(proveedor);
    }

    // Actualizar un proveedor
    public Proveedor actualizarProveedor(Proveedor proveedor) {
        if (proveedor == null || proveedor.getNit() == null || proveedor.getNit().isEmpty()) {
            return null;
        }
        Proveedor proveedorExistente = proveedorDao.consultarProveedorIndividual(proveedor.getNit());
        if (proveedorExistente == null) {
            return null;
        }
        return proveedorDao.actualizarProveedor(proveedor);
    }

    // Eliminar un proveedor por su NIT
    public boolean eliminarProveedor(String nit) {
        Proveedor proveedorExistente = proveedorDao.consultarProveedorIndividual(nit);
        if (proveedorExistente == null) {
            return false;
        }
        return proveedorDao.eliminarProveedor(nit);
    }
}
