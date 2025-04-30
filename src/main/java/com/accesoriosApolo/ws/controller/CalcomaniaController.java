package com.accesoriosApolo.ws.controller;

import com.accesoriosApolo.ws.dto.CalcomaniaDto;
import com.accesoriosApolo.ws.service.CalcomaniaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicio-calcomanias")
public class CalcomaniaController {

    private final CalcomaniaService calcomaniaService;

    @Autowired
    public CalcomaniaController(CalcomaniaService calcomaniaService) {
        this.calcomaniaService = calcomaniaService;
    }

    @GetMapping("/calcomanias/{id}")
    public ResponseEntity<?> getCalcomaniaPorId(@PathVariable("id") int id_calcomania) {
        if (id_calcomania <= 0) {
            return ResponseEntity.badRequest().body("El parámetro 'id' debe ser mayor a cero.");
        }
        CalcomaniaDto calcomaniaDto = calcomaniaService.obtenerCalcomaniaPorId(id_calcomania);
        if (calcomaniaDto == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Calcomanía no encontrada para el ID: " + id_calcomania);
        }
        return ResponseEntity.ok(calcomaniaDto);
    }

    @GetMapping("/calcomanias-list")
    public ResponseEntity<List<CalcomaniaDto>> getCalcomanias() {
        try {
            List<CalcomaniaDto> calcomaniaDtos = calcomaniaService.obtenerListaCalcomanias();

            if (calcomaniaDtos.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }

            return ResponseEntity.ok(calcomaniaDtos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }

    @PostMapping("/registrar")
    public ResponseEntity<CalcomaniaDto> registrarCalcomania(@RequestBody CalcomaniaDto calcomaniaDto) {
        CalcomaniaDto nuevaCalcomania = calcomaniaService.registrarCalcomania(calcomaniaDto);
        if (nuevaCalcomania != null) {
            return ResponseEntity.ok(nuevaCalcomania);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/actualizar")
    public ResponseEntity<?> actualizarCalcomania(@RequestBody CalcomaniaDto calcomaniaDto) {
        CalcomaniaDto calcomaniaActualizada = calcomaniaService.actualizarCalcomania(calcomaniaDto);

        if (calcomaniaActualizada == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontró una calcomanía con el ID especificado.");
        }
        return ResponseEntity.ok(calcomaniaActualizada);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarCalcomania(@PathVariable int id) {
        if (id <= 0) {
            return ResponseEntity.badRequest()
                    .body("El ID es obligatorio y debe ser mayor a cero para eliminar una calcomanía.");
        }
        boolean eliminado = calcomaniaService.eliminarCalcomania(id);
        if (eliminado) {
            return ResponseEntity.ok("Calcomanía eliminada exitosamente.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontró una calcomanía con el ID especificado.");
        }
    }
}
