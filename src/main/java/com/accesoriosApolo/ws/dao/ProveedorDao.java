package com.accesoriosApolo.ws.dao;

import com.accesoriosApolo.ws.dto.ProveedorDto;
import com.accesoriosApolo.ws.util.ProveedorUtilidades;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProveedorDao {

    public ProveedorDao() {
        ProveedorUtilidades.iniciarLista();
    }

    public static ProveedorDto consultarProveedorIndividual(String nit) {
        for (ProveedorDto p : ProveedorUtilidades.listaProveedores) {
            if (p.getNit().equals(nit)) {
                return p;
            }
        }
        return null;
    }

    public List<ProveedorDto> obtenerListaProveedores() {
        return ProveedorUtilidades.listaProveedores;
    }

    public ProveedorDto registrarProveedor(ProveedorDto proveedorDto) {
        for (ProveedorDto obj : ProveedorUtilidades.listaProveedores) {
            if (obj.getNit().equals(proveedorDto.getNit())) {
                return null;
            }
        }
        ProveedorUtilidades.listaProveedores.add(proveedorDto);
        return proveedorDto;
    }

    public ProveedorDto actualizarProveedor(ProveedorDto proveedorDto) {
        for (ProveedorDto obj : ProveedorUtilidades.listaProveedores) {
            if (obj.getNit().equals(proveedorDto.getNit())) {
                obj.setNombre(proveedorDto.getNombre());
                obj.setEmpresa(proveedorDto.getEmpresa());
                obj.setCorreo(proveedorDto.getCorreo());
                obj.setTelefono(proveedorDto.getTelefono());
                obj.setDireccion(proveedorDto.getDireccion());
                return obj;
            }
        }
        return null;
    }

    public boolean eliminarProveedor(ProveedorDto proveedorDto) {
        return ProveedorUtilidades.listaProveedores.removeIf(p -> p.getNit().equals(proveedorDto.getNit()));
    }
}
