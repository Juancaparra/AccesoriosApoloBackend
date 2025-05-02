package com.accesoriosApolo.ws.repository;

import com.accesoriosApolo.ws.dto.CalcomaniaDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalcomaniaRepository extends JpaRepository<CalcomaniaDto, Long> {

    // Método personalizado para buscar por referencia
    CalcomaniaDto findByReferencia(String referencia);

    // Método personalizado para eliminar por referencia
    void deleteByReferencia(String referencia);
}
