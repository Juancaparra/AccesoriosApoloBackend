package com.accesoriosApolo.ws.repository;

import com.accesoriosApolo.ws.dto.ProveedorDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProveedorRepository extends JpaRepository<ProveedorDto, String> {
    ProveedorDto findByNit(String nit);
    ProveedorDto findByReferencia(String referencia);
    void deleteByReferencia(String referencia);
}
