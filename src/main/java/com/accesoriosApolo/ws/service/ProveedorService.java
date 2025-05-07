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

    public Proveedor obtenerProveedorPorNit(String nit) {
        return proveedorDao.consultarProveedorIndividual(nit);
    }

    public List<Proveedor> obtenerListaProveedor() {
        return proveedorDao.obtenerListaProveedores();
    }

    public Proveedor registrarProveedor(Proveedor proveedor) {
        if (proveedor == null || proveedor.getNit() == null || proveedor.getNit().isEmpty()) {
            return null;
        }
        return proveedorDao.registrarProveedor(proveedor);
    }

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

    public boolean eliminarProveedor(String nit) {
        Proveedor proveedorExistente = proveedorDao.consultarProveedorIndividual(nit);
        if (proveedorExistente == null) {
            return false;
        }
        return proveedorDao.eliminarProveedor(proveedorExistente);
    }
}
