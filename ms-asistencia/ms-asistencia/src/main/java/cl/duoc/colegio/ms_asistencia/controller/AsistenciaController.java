package cl.duoc.colegio.ms_asistencia.controller;

import cl.duoc.colegio.ms_asistencia.model.Asistencia;
import cl.duoc.colegio.ms_asistencia.service.AsistenciaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/asistencias")
public class AsistenciaController {

    private final AsistenciaService service;

    public AsistenciaController(AsistenciaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Asistencia> listarTodas() {
        return service.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Asistencia> obtenerPorId(@PathVariable Long id) {
        return service.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/alumno/{alumnoId}")
    public List<Asistencia> listarPorAlumno(@PathVariable Long alumnoId) {
        return service.listarPorAlumno(alumnoId);
    }

    @GetMapping("/fecha/{fecha}")
    public List<Asistencia> listarPorFecha(@PathVariable String fecha) {
        return service.listarPorFecha(fecha);
    }

    @PostMapping
    public Asistencia crear(@RequestBody Asistencia asistencia) {
        return service.crear(asistencia);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Asistencia> actualizar(@PathVariable Long id, @RequestBody Asistencia datos) {
        return ResponseEntity.ok(service.actualizar(id, datos));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
