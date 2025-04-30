package com.accesoriosApolo.ws.service;

import com.accesoriosApolo.ws.dao.CalcomaniaDao;
import com.accesoriosApolo.ws.dto.CalcomaniaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalcomaniaService {

    private final CalcomaniaDao calcomaniaDao;

    @Autowired
    public CalcomaniaService(CalcomaniaDao calcomaniaDao) {
        this.calcomaniaDao = calcomaniaDao;
    }

    public CalcomaniaDto obtenerCalcomaniaPorId(int id_calcomania) {
        return CalcomaniaDao.consultarCalcomaniaIndividual(id_calcomania);
    }

    public List<CalcomaniaDto> obtenerListaCalcomanias() {
        return calcomaniaDao.obtenerListaCalcomanias();
    }

    public CalcomaniaDto registrarCalcomania(CalcomaniaDto calcomaniaDto) {
        if (calcomaniaDto == null || calcomaniaDto.getNombre() == null || calcomaniaDto.getNombre().isEmpty()) {
            return null;
        }

        return calcomaniaDao.registrarCalcomania(calcomaniaDto);
    }

    public CalcomaniaDto actualizarCalcomania(CalcomaniaDto calcomaniaDto) {
        if (calcomaniaDto == null || calcomaniaDto.getId_calcomania() == 0) {
            return null;
        }

        CalcomaniaDto calcomaniaExistente = CalcomaniaDao.consultarCalcomaniaIndividual(calcomaniaDto.getId_calcomania());
        if (calcomaniaExistente == null) {
            return null;
        }

        return calcomaniaDao.actualizarCalcomania(calcomaniaDto);
    }

    public boolean eliminarCalcomania(int id_calcomania) {
        CalcomaniaDto calcomaniaExistente = CalcomaniaDao.consultarCalcomaniaIndividual(id_calcomania);

        if (calcomaniaExistente == null) {
            return false;
        }
        return calcomaniaDao.eliminarCalcomania(calcomaniaExistente);
    }
}
