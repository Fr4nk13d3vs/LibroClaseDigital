package cl.duoc.colegio.ms_academico.controller;

import cl.duoc.colegio.ms_academico.model.Asignatura;
import cl.duoc.colegio.ms_academico.service.AsignaturaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/asignaturas")
public class AsignaturaController {

    private final AsignaturaService service;

    public AsignaturaController(AsignaturaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Asignatura> listarTodas() {
        return service.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Asignatura> obtenerPorId(@PathVariable Long id) {
        return service.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Asignatura crear(@RequestBody Asignatura asignatura) {
        return service.crear(asignatura);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Asignatura> actualizar(@PathVariable Long id, @RequestBody Asignatura datos) {
        return ResponseEntity.ok(service.actualizar(id, datos));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
