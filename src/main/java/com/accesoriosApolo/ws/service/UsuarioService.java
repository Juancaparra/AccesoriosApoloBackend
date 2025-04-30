package com.accesoriosApolo.ws.service;

import com.accesoriosApolo.ws.dao.UsuarioDao;
import com.accesoriosApolo.ws.dto.UsuarioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioDao usuarioDao;

    @Autowired
    public UsuarioService(UsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }

    public UsuarioDto obtenerUsuarioPorCedula(int cedula) {
        return usuarioDao.consultarUsuarioIndividual(cedula);
    }

    public List<UsuarioDto> obtenerListaUsuarios() {
        return usuarioDao.obtenerListaUsuarios();
    }

    public UsuarioDto registrarUsuario(UsuarioDto usuarioDto) {
        if (usuarioDto == null || usuarioDto.getCedula() == 0) {
            return null;
        }

        UsuarioDto usuarioExistente = usuarioDao.consultarUsuarioIndividual(usuarioDto.getCedula());
        if (usuarioExistente != null) {
            return null;
        }

        return usuarioDao.registrarUsuario(usuarioDto);
    }


    public UsuarioDto actualizarUsuario(UsuarioDto usuarioDto) {
        if (usuarioDto == null || usuarioDto.getCedula() == 0) {
            return null;
        }
        UsuarioDto usuarioExistente = usuarioDao.consultarUsuarioIndividual(usuarioDto.getCedula());
        if (usuarioExistente == null) {
            return null;
        }
        return usuarioDao.actualizarUsuario(usuarioDto);
    }

    public boolean eliminarUsuario(int cedula) {
        UsuarioDto usuarioExistente = usuarioDao.consultarUsuarioIndividual(cedula);
        if (usuarioExistente == null) {
            return false;
        }
        return usuarioDao.eliminarUsuario(cedula);
    }
}
