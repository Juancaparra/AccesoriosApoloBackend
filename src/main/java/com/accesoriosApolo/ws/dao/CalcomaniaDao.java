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

    // Obtener una calcomanía por su ID
    public Calcomania consultarCalcomaniaIndividual(Long idCalcomania) {
        return calcomaniaRepository.findById(idCalcomania).orElse(null);
    }

    // Obtener todas las calcomanías
    public List<Calcomania> obtenerListaCalcomanias() {
        return calcomaniaRepository.findAll();
    }

    // Registrar una nueva calcomanía
    public Calcomania registrarCalcomania(Calcomania calcomania) {
        return calcomaniaRepository.save(calcomania);
    }

    // Actualizar una calcomanía
    public Calcomania actualizarCalcomania(Calcomania calcomania) {
        return calcomaniaRepository.save(calcomania);
    }

    // Eliminar una calcomanía por su ID
    public boolean eliminarCalcomania(Long idCalcomania) {
        try {
            calcomaniaRepository.deleteById(idCalcomania);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
