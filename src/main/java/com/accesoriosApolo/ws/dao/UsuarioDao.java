package com.accesoriosApolo.ws.dao;

import com.accesoriosApolo.ws.Entidades.Usuario;
import com.accesoriosApolo.ws.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UsuarioDao {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario consultarUsuarioIndividual(int cedula) {
        return usuarioRepository.findByCedula(cedula);
    }

    public List<Usuario> obtenerListaUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario registrarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario actualizarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public boolean eliminarUsuario(int cedula) {
        try {
            Usuario usuario = usuarioRepository.findByCedula(cedula);
            if (usuario != null) {
                usuarioRepository.delete(usuario);
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    // Métodos opcionales si aún necesitas trabajar con ID tipo Long
    public Usuario obtenerUsuario(Integer id) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(id);
        return usuarioOpt.orElse(null);
    }

    public void eliminarUsuario(Integer id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
        }
    }
}
