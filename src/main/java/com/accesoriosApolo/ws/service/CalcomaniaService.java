package com.accesoriosApolo.ws.service;

import com.accesoriosApolo.ws.dao.CalcomaniaDao;
import com.accesoriosApolo.ws.Entidades.Calcomania;
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

    public Calcomania obtenerCalcomaniaPorId(long idCalcomania) {
        return calcomaniaDao.consultarCalcomaniaIndividual(idCalcomania);
    }

    public List<Calcomania> obtenerListaCalcomanias() {
        return calcomaniaDao.obtenerListaCalcomanias();
    }

    public Calcomania registrarCalcomania(Calcomania calcomania) {
        if (calcomania == null || calcomania.getNombre() == null || calcomania.getNombre().isEmpty()) {
            return null;
        }

        return calcomaniaDao.registrarCalcomania(calcomania);
    }

    public Calcomania actualizarCalcomania(Calcomania calcomania) {
        if (calcomania == null || calcomania.getIdCalcomania() == null || calcomania.getIdCalcomania() == 0) {
            return null;
        }

        Calcomania calcomaniaExistente = calcomaniaDao.consultarCalcomaniaIndividual(calcomania.getIdCalcomania());
        if (calcomaniaExistente == null) {
            return null;
        }

        return calcomaniaDao.actualizarCalcomania(calcomania);
    }

    public boolean eliminarCalcomania(long idCalcomania) {
        Calcomania calcomaniaExistente = calcomaniaDao.consultarCalcomaniaIndividual(idCalcomania);
        if (calcomaniaExistente == null) {
            return false;
        }

        return calcomaniaDao.eliminarCalcomania(calcomaniaExistente);
    }
}
