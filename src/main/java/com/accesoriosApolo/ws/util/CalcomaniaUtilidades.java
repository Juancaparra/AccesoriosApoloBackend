package com.accesoriosApolo.ws.util;

import com.accesoriosApolo.ws.dto.CalcomaniaDto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CalcomaniaUtilidades {

    static int conteo = 0;

    public static List<CalcomaniaDto> listaCalcomanias = new ArrayList<>();

    public static void iniciarLista() {
        if (conteo == 0) {
            listaCalcomanias.add(new CalcomaniaDto(
                    1,
                    "Calcomanía Llama",
                    new Date(),
                    "PNG",
                    "https://servidor.com/imagenes/llama.png",
                    "512KB",
                    10123456
            ));
            listaCalcomanias.add(new CalcomaniaDto(
                    2,
                    "Calcomanía Rayo",
                    new Date(),
                    "JPG",
                    "https://servidor.com/imagenes/rayo.jpg",
                    "750KB",
                    10123457
            ));
            conteo = 1;
        }
    }
}
