package com.accesoriosApolo.ws.dao;

import com.accesoriosApolo.ws.dto.CalcomaniaDto;
import com.accesoriosApolo.ws.util.CalcomaniaUtilidades;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CalcomaniaDao {

    public CalcomaniaDao() {CalcomaniaUtilidades.iniciarLista();
    }

    public static CalcomaniaDto consultarCalcomaniaIndividual(int idCalcomania) {
        for (CalcomaniaDto c : CalcomaniaUtilidades.listaCalcomanias) {
            if (c.getIdCalcomania() == idCalcomania) {
                CalcomaniaDto calcomaniaDto = new CalcomaniaDto();
                calcomaniaDto.setIdCalcomania(c.getIdCalcomania());
                calcomaniaDto.setNombre(c.getNombre());
                calcomaniaDto.setFechaSubida(c.getFechaSubida());
                calcomaniaDto.setFormato(c.getFormato());
                calcomaniaDto.setUrlArchivo(c.getUrlArchivo());
                calcomaniaDto.setTamañoArchivo(c.getTamañoArchivo());
                calcomaniaDto.setFkCedula(c.getFkCedula());
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
            if (obj.getIdCalcomania() == calcomaniaDto.getIdCalcomania()) {
                return null;
            }
        }

        CalcomaniaUtilidades.listaCalcomanias.add(calcomaniaDto);
        return calcomaniaDto;
    }

    public CalcomaniaDto actualizarCalcomania(CalcomaniaDto calcomaniaDto) {
        for (CalcomaniaDto obj : CalcomaniaUtilidades.listaCalcomanias) {
            if (obj.getIdCalcomania() == calcomaniaDto.getIdCalcomania()) {
                obj.setNombre(calcomaniaDto.getNombre());
                obj.setFechaSubida(calcomaniaDto.getFechaSubida());
                obj.setFormato(calcomaniaDto.getFormato());
                obj.setUrlArchivo(calcomaniaDto.getUrlArchivo());
                obj.setTamañoArchivo(calcomaniaDto.getTamañoArchivo());
                obj.setFkCedula(calcomaniaDto.getFkCedula());
                return obj;
            }
        }
        return null;
    }

    public boolean eliminarCalcomania(CalcomaniaDto calcomaniaDto) {
        for (int i = 0; i < CalcomaniaUtilidades.listaCalcomanias.size(); i++) {
            if (CalcomaniaUtilidades.listaCalcomanias.get(i).getIdCalcomania() == calcomaniaDto.getIdCalcomania()) {
                CalcomaniaUtilidades.listaCalcomanias.remove(i);
                return true;
            }
        }
        return false;
    }
}
