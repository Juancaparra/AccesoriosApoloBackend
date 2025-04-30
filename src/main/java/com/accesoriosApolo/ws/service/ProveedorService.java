package com.accesoriosApolo.ws.service;

import com.accesoriosApolo.ws.dao.ProveedorDao;
import com.accesoriosApolo.ws.dto.ProveedorDto;
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

    public ProveedorDto obtenerProveedorPorNit(String nit) {
        return ProveedorDao.consultarProveedorIndividual(nit);
    }

    public List<ProveedorDto> obtenerListaProveedor() {
        return proveedorDao.obtenerListaProveedores();
    }

    public ProveedorDto registrarProveedor(ProveedorDto proveedorDto) {
        if (proveedorDto == null || proveedorDto.getNit() == null || proveedorDto.getNit().isEmpty()) {
            return null;
        }
        return proveedorDao.registrarProveedor(proveedorDto);
    }

    public ProveedorDto actualizarProveedor(ProveedorDto proveedorDto) {
        if (proveedorDto == null || proveedorDto.getNit() == null || proveedorDto.getNit().isEmpty()) {
            return null;
        }
        ProveedorDto proveedorExistente = ProveedorDao.consultarProveedorIndividual(proveedorDto.getNit());
        if (proveedorExistente == null) {
            return null;
        }
        return proveedorDao.actualizarProveedor(proveedorDto);
    }

    public boolean eliminarProveedor(String nit) {
        ProveedorDto proveedorExistente = ProveedorDao.consultarProveedorIndividual(nit);
        if (proveedorExistente == null) {
            return false;
        }
        return proveedorDao.eliminarProveedor(proveedorExistente);
    }
}
