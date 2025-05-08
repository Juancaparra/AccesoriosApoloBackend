package com.accesoriosApolo.ws.repository;

import com.accesoriosApolo.ws.Entidades.Calcomania;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalcomaniaRepository extends JpaRepository<Calcomania, Long> {

}
