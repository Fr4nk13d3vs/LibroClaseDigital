package cl.duoc.colegio.ms_academico.controller;

import cl.duoc.colegio.ms_academico.model.Evaluacion;
import cl.duoc.colegio.ms_academico.service.EvaluacionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/evaluaciones")
public class EvaluacionController {

    private final EvaluacionService service;

    public EvaluacionController(EvaluacionService service) {
        this.service = service;
    }

    @GetMapping
    public List<Evaluacion> listarTodas() {
        return service.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Evaluacion> obtenerPorId(@PathVariable Long id) {
        return service.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/alumno/{alumnoId}")
    public List<Evaluacion> listarPorAlumno(@PathVariable Long alumnoId) {
        return service.listarPorAlumno(alumnoId);
    }

    @GetMapping("/asignatura/{asignaturaId}")
    public List<Evaluacion> listarPorAsignatura(@PathVariable Long asignaturaId) {
        return service.listarPorAsignatura(asignaturaId);
    }

    @PostMapping
    public Evaluacion crear(@RequestBody Evaluacion evaluacion) {
        return service.crear(evaluacion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Evaluacion> actualizar(@PathVariable Long id, @RequestBody Evaluacion datos) {
        return ResponseEntity.ok(service.actualizar(id, datos));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
