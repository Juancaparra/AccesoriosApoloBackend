package com.accesoriosApolo.ws.dao;

import com.accesoriosApolo.ws.dto.CalcomaniaDto;
import com.accesoriosApolo.ws.util.CalcomaniaUtilidades;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CalcomaniaDao {

    public CalcomaniaDao() {
        CalcomaniaUtilidades.iniciarLista();
    }

    public static CalcomaniaDto consultarCalcomaniaIndividual(int id_calcomania) {
        for (CalcomaniaDto c : CalcomaniaUtilidades.listaCalcomanias) {
            if (c.getId_calcomania() == id_calcomania) {
                CalcomaniaDto calcomaniaDto = new CalcomaniaDto();
                calcomaniaDto.setId_calcomania(c.getId_calcomania());
                calcomaniaDto.setNombre(c.getNombre());
                calcomaniaDto.setFecha_subida(c.getFecha_subida());
                calcomaniaDto.setFormato(c.getFormato());
                calcomaniaDto.setUrl_archivo(c.getUrl_archivo());
                calcomaniaDto.setTamaño_archivo(c.getTamaño_archivo());
                calcomaniaDto.setFk_cedula(c.getFk_cedula());
                return calcomaniaDto;
            }
        }
        return null;
    }

    public List<CalcomaniaDto> obtenerListaCalcomanias() {
        return CalcomaniaUtilidades.listaCalcomanias;
    }

    public CalcomaniaDto registrarCalcomania(CalcomaniaDto calcomaniaDto) {
        for (CalcomaniaDto obj : CalcomaniaUtilidades.listaCalcomanias) {
            if (obj.getId_calcomania() == calcomaniaDto.getId_calcomania()) {
                return null;
            }
        }

        CalcomaniaUtilidades.listaCalcomanias.add(calcomaniaDto);

        return calcomaniaDto;
    }

    public CalcomaniaDto actualizarCalcomania(CalcomaniaDto calcomaniaDto) {
        for (CalcomaniaDto obj : CalcomaniaUtilidades.listaCalcomanias) {
            if (obj.getId_calcomania() == calcomaniaDto.getId_calcomania()) {
                obj.setNombre(calcomaniaDto.getNombre());
                obj.setFecha_subida(calcomaniaDto.getFecha_subida());
                obj.setFormato(calcomaniaDto.getFormato());
                obj.setUrl_archivo(calcomaniaDto.getUrl_archivo());
                obj.setTamaño_archivo(calcomaniaDto.getTamaño_archivo());
                obj.setFk_cedula(calcomaniaDto.getFk_cedula());

                return obj;
            }
        }
        return null;
    }

    public boolean eliminarCalcomania(CalcomaniaDto calcomaniaDto) {
        for (int i = 0; i < CalcomaniaUtilidades.listaCalcomanias.size(); i++) {
            if (CalcomaniaUtilidades.listaCalcomanias.get(i).getId_calcomania() == calcomaniaDto.getId_calcomania()) {
                CalcomaniaUtilidades.listaCalcomanias.remove(i);
                return true;
            }
        }
        return false;
    }
}
