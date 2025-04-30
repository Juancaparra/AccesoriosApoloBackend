package com.accesoriosApolo.ws.dao;

import com.accesoriosApolo.ws.dto.UsuarioDto;
import com.accesoriosApolo.ws.util.UsuarioUtilidades;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsuarioDao {

    public UsuarioDao() {
        UsuarioUtilidades.iniciarLista();
    }

    public UsuarioDto consultarUsuarioIndividual(int cedula) {
        for (UsuarioDto u : UsuarioUtilidades.listaUsuarios) {
            if (u.getCedula() == cedula) {
                return u;
            }
        }
        return null;
    }


    public List<UsuarioDto> obtenerListaUsuarios() {
        return UsuarioUtilidades.listaUsuarios;
    }

    public UsuarioDto registrarUsuario(UsuarioDto usuarioDto) {
        for (UsuarioDto u : UsuarioUtilidades.listaUsuarios) {
            if (u.getCedula() == usuarioDto.getCedula()) {
                return null;
            }
        }
        UsuarioUtilidades.listaUsuarios.add(usuarioDto);
        return usuarioDto;
    }

    public UsuarioDto actualizarUsuario(UsuarioDto usuarioDto) {
        for (UsuarioDto u : UsuarioUtilidades.listaUsuarios) {
            if (u.getCedula() == usuarioDto.getCedula()) {
                u.setNombre(usuarioDto.getNombre());
                u.setCorreo(usuarioDto.getCorreo());
                u.setTelefono(usuarioDto.getTelefono());
                u.setContrasena(usuarioDto.getContrasena());
                return u;
            }
        }
        return null;
    }

    public boolean eliminarUsuario(int cedula) {
        for (int i = 0; i < UsuarioUtilidades.listaUsuarios.size(); i++) {
            if (UsuarioUtilidades.listaUsuarios.get(i).getCedula() == cedula) {
                UsuarioUtilidades.listaUsuarios.remove(i);
                return true;
            }
        }
        return false;
    }

}
