package com.accesoriosApolo.ws.repository;

import com.accesoriosApolo.ws.Entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, String> {
    // Puedes agregar consultas personalizadas aquí si lo necesitas
}
