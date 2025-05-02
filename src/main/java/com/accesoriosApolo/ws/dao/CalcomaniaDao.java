package com.accesoriosApolo.ws.dao;

import com.accesoriosApolo.ws.dto.CalcomaniaDto;
import com.accesoriosApolo.ws.repository.CalcomaniaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CalcomaniaDao {

    @Autowired
    private CalcomaniaRepository calcomaniaRepository;

    public CalcomaniaDto consultarCalcomaniaIndividual(Long idCalcomania) {
        return calcomaniaRepository.findById(idCalcomania).orElse(null);
    }

    public List<CalcomaniaDto> obtenerListaCalcomanias() {
        return calcomaniaRepository.findAll();
    }

    public CalcomaniaDto registrarCalcomania(CalcomaniaDto calcomaniaDto) {
        return calcomaniaRepository.save(calcomaniaDto);
    }

    public CalcomaniaDto actualizarCalcomania(CalcomaniaDto calcomaniaDto) {
        return calcomaniaRepository.save(calcomaniaDto);
    }

    public boolean eliminarCalcomania(CalcomaniaDto calcomaniaDto) {
        try {
            calcomaniaRepository.delete(calcomaniaDto);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Métodos adicionales basados en referencia (ya existentes)
    public CalcomaniaDto obtenerCalcomania(String referencia) {
        return calcomaniaRepository.findByReferencia(referencia);
    }

    public CalcomaniaDto guardarCalcomania(CalcomaniaDto calcomaniaDto) {
        return calcomaniaRepository.save(calcomaniaDto);
    }

    public void eliminarCalcomania(String referencia) {
        calcomaniaRepository.deleteByReferencia(referencia);
    }
}
