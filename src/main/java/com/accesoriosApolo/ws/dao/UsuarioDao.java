package com.accesoriosApolo.ws.dao;

import com.accesoriosApolo.ws.dto.UsuarioDto;
import com.accesoriosApolo.ws.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UsuarioDao {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioDto consultarUsuarioIndividual(int cedula) {
        return usuarioRepository.findByCedula(cedula);
    }

    public List<UsuarioDto> obtenerListaUsuarios() {
        return usuarioRepository.findAll();
    }

    public UsuarioDto registrarUsuario(UsuarioDto usuarioDto) {
        return usuarioRepository.save(usuarioDto);
    }

    public UsuarioDto actualizarUsuario(UsuarioDto usuarioDto) {
        return usuarioRepository.save(usuarioDto);
    }

    public boolean eliminarUsuario(int cedula) {
        try {
            UsuarioDto usuario = usuarioRepository.findByCedula(cedula);
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
    public UsuarioDto obtenerUsuario(Long id) {
        Optional<UsuarioDto> usuarioOpt = usuarioRepository.findById(id);
        return usuarioOpt.orElse(null);
    }

    public void eliminarUsuario(Long id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
        }
    }
}
