package cl.duoc.colegio.ms_academico.controller;

import cl.duoc.colegio.ms_academico.model.Profesor;
import cl.duoc.colegio.ms_academico.service.ProfesorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profesores")
public class ProfesorController {

    private final ProfesorService service;

    public ProfesorController(ProfesorService service) {
        this.service = service;
    }

    @GetMapping
    public List<Profesor> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Profesor> obtenerPorId(@PathVariable Long id) {
        return service.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Profesor crear(@RequestBody Profesor profesor) {
        return service.crear(profesor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Profesor> actualizar(@PathVariable Long id, @RequestBody Profesor datos) {
        return ResponseEntity.ok(service.actualizar(id, datos));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
