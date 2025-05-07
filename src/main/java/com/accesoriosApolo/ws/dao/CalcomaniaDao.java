package com.accesoriosApolo.ws.dao;

import com.accesoriosApolo.ws.Entidades.Calcomania;
import com.accesoriosApolo.ws.repository.CalcomaniaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CalcomaniaDao {

    @Autowired
    private CalcomaniaRepository calcomaniaRepository;

    public Calcomania consultarCalcomaniaIndividual(Long idCalcomania) {
        return calcomaniaRepository.findById(idCalcomania).orElse(null);
    }

    public List<Calcomania> obtenerListaCalcomanias() {
        return calcomaniaRepository.findAll();
    }

    public Calcomania registrarCalcomania(Calcomania calcomania) {
        return calcomaniaRepository.save(calcomania);
    }

    public Calcomania actualizarCalcomania(Calcomania calcomania) {
        return calcomaniaRepository.save(calcomania);
    }

    public boolean eliminarCalcomania(Calcomania calcomania) {
        try {
            calcomaniaRepository.delete(calcomania);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Métodos adicionales basados en referencia (ya existentes)
    public Calcomania obtenerCalcomania(String referencia) {
        return calcomaniaRepository.findByReferencia(referencia);
    }

    public Calcomania guardarCalcomania(Calcomania calcomania) {
        return calcomaniaRepository.save(calcomania);
    }

    public void eliminarCalcomania(String referencia) {
        calcomaniaRepository.deleteByReferencia(referencia);
    }
}
