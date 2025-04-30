package com.accesoriosApolo.ws.util;

import com.accesoriosApolo.ws.dto.UsuarioDto;

import java.util.ArrayList;
import java.util.List;

public class UsuarioUtilidades {

    static int conteo = 0;

    public static final List<UsuarioDto> listaUsuarios = new ArrayList<>();

    public static void iniciarLista() {
        if (conteo == 0) {
            listaUsuarios.add(new UsuarioDto(1001, "Juan Pérez", "3001234567", "juan.perez@gmail.com", "1234", "ADMIN"));
            listaUsuarios.add(new UsuarioDto(1002, "Ana Romero", "3009876543", "ana.romero@hotmail.com", "5678", "CLIENTE"));
            conteo++;
        }
    }
}
