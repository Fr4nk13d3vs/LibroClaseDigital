package cl.duoc.colegio.ms_asistencia.controller;

import cl.duoc.colegio.ms_asistencia.model.Anotacion;
import cl.duoc.colegio.ms_asistencia.service.AnotacionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/anotaciones")
public class AnotacionController {

    private final AnotacionService service;

    public AnotacionController(AnotacionService service) {
        this.service = service;
    }

    @GetMapping
    public List<Anotacion> listarTodas() {
        return service.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Anotacion> obtenerPorId(@PathVariable Long id) {
        return service.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/alumno/{alumnoId}")
    public List<Anotacion> listarPorAlumno(@PathVariable Long alumnoId) {
        return service.listarPorAlumno(alumnoId);
    }

    @PostMapping
    public Anotacion crear(@RequestBody Anotacion anotacion) {
        return service.crear(anotacion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Anotacion> actualizar(@PathVariable Long id, @RequestBody Anotacion datos) {
        return ResponseEntity.ok(service.actualizar(id, datos));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
