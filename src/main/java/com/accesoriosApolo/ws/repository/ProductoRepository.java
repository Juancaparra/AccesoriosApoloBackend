package com.accesoriosApolo.ws.repository;

import com.accesoriosApolo.ws.dto.ProductoDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoDto, String> {
    // Puedes agregar consultas personalizadas aquí si lo necesitas
}
