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

    // Obtener una calcomanía por su ID
    public Calcomania obtenerCalcomaniaPorId(long idCalcomania) {
        return calcomaniaDao.consultarCalcomaniaIndividual(idCalcomania);
    }

    // Obtener todas las calcomanías
    public List<Calcomania> obtenerListaCalcomanias() {
        return calcomaniaDao.obtenerListaCalcomanias();
    }

    // Registrar una nueva calcomanía
    public Calcomania registrarCalcomania(Calcomania calcomania) {
        if (calcomania == null || calcomania.getNombre() == null || calcomania.getNombre().isEmpty()) {
            return null;
        }
        return calcomaniaDao.registrarCalcomania(calcomania);
    }

    // Actualizar una calcomanía
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

    // Eliminar una calcomanía por su ID
    public boolean eliminarCalcomania(long idCalcomania) {
        Calcomania calcomaniaExistente = calcomaniaDao.consultarCalcomaniaIndividual(idCalcomania);
        if (calcomaniaExistente == null) {
            return false;
        }
        return calcomaniaDao.eliminarCalcomania(idCalcomania);
    }
}
