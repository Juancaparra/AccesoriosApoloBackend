package com.accesoriosApolo.ws.util;

import com.accesoriosApolo.ws.dto.ProductoDto;

import java.util.ArrayList;
import java.util.List;

public class ProductoUtilidades {

    static int conteo=0;

    public static List<ProductoDto> listaProductos=new ArrayList<ProductoDto>();

    public static void iniciarLista(){
        if (conteo==0){
            listaProductos.add(new ProductoDto("2001",
                    "Casco Integral Moto",
                    "Casco integral con visor solar interno y ventilación frontal.",
                    "L",
                    20,
                    89.99f,
                    1.45f,
                    "Material: ABS, homologación DOT y ECE, acolchado desmontable.",
                    74.99f,
                    3 ));
            listaProductos.add(new ProductoDto("2002",
                    "Chaqueta Moto Impermeable",
                    "Chaqueta con protecciones, reflectantes y forro térmico desmontable.",
                    "XL",
                    15,
                    129.99f,
                    2.30f,
                    "Tejido Oxford 600D, protecciones CE en hombros y codos, resistente al agua.",
                    109.99f,
                    3));
            conteo=1;
        }
    }

}
