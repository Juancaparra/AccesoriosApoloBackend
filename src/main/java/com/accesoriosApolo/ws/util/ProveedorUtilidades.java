package com.accesoriosApolo.ws.util;

import com.accesoriosApolo.ws.dto.ProveedorDto;

import java.util.ArrayList;
import java.util.List;

public class ProveedorUtilidades {

    static int conteo = 0;
    public static List<ProveedorDto> listaProveedores = new ArrayList<>();

    public static void iniciarLista() {
        if (conteo == 0) {
            listaProveedores.add(new ProveedorDto(
                    "1098262814",
                    "Carlos",
                    "Casco Loco",
                    "carlos@gmail.com",
                    "323468931",
                    "Activo",
                    "12 Norte"
            ));
            listaProveedores.add(new ProveedorDto(
                    "2002",
                    "Javier",
                    "MotosPro",
                    "javier@motospro.com",
                    "321458963",
                    "Activo",
                    "Avenida Central #45"
            ));
            conteo++;
        }
    }
}
