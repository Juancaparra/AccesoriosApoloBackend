package com.accesoriosApolo.ws.service;

import com.accesoriosApolo.ws.dao.UsuarioDao;
import com.accesoriosApolo.ws.Entidades.Usuario;
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

    public Usuario obtenerUsuarioPorCedula(int cedula) {
        return usuarioDao.consultarUsuarioIndividual(cedula);
    }

    public List<Usuario> obtenerListaUsuarios() {
        return usuarioDao.obtenerListaUsuarios();
    }

    public Usuario registrarUsuario(Usuario usuario) {
        if (usuario == null || usuario.getCedula() == 0) {
            return null;
        }

        Usuario usuarioExistente = usuarioDao.consultarUsuarioIndividual(usuario.getCedula());
        if (usuarioExistente != null) {
            return null;
        }

        return usuarioDao.registrarUsuario(usuario);
    }


    public Usuario actualizarUsuario(Usuario usuario) {
        if (usuario == null || usuario.getCedula() == 0) {
            return null;
        }
        Usuario usuarioExistente = usuarioDao.consultarUsuarioIndividual(usuario.getCedula());
        if (usuarioExistente == null) {
            return null;
        }
        return usuarioDao.actualizarUsuario(usuario);
    }

    public boolean eliminarUsuario(int cedula) {
        Usuario usuarioExistente = usuarioDao.consultarUsuarioIndividual(cedula);
        if (usuarioExistente == null) {
            return false;
        }
        return usuarioDao.eliminarUsuario(cedula);
    }
}
