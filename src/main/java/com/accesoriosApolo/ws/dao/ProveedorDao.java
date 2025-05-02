package com.accesoriosApolo.ws.dao;

import com.accesoriosApolo.ws.dto.ProveedorDto;
import com.accesoriosApolo.ws.repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProveedorDao {

    @Autowired
    private ProveedorRepository proveedorRepository;

    public ProveedorDto consultarProveedorIndividual(String nit) {
        return proveedorRepository.findByNit(nit);
    }

    public List<ProveedorDto> obtenerListaProveedores() {
        return proveedorRepository.findAll();
    }

    public ProveedorDto registrarProveedor(ProveedorDto proveedorDto) {
        return proveedorRepository.save(proveedorDto);
    }

    public ProveedorDto actualizarProveedor(ProveedorDto proveedorDto) {
        return proveedorRepository.save(proveedorDto);
    }

    public boolean eliminarProveedor(ProveedorDto proveedorDto) {
        try {
            proveedorRepository.delete(proveedorDto);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Métodos antiguos (basados en referencia, si los necesitas)
    public ProveedorDto obtenerProveedor(String referencia) {
        return proveedorRepository.findByReferencia(referencia);
    }

    public void eliminarProveedor(String referencia) {
        proveedorRepository.deleteByReferencia(referencia);
    }
}
