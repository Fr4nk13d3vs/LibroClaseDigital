package cl.duoc.colegio.ms_academico.controller;

import cl.duoc.colegio.ms_academico.model.Alumno;
import cl.duoc.colegio.ms_academico.service.AlumnoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alumnos")
public class AlumnoController {

    private final AlumnoService service;

    public AlumnoController(AlumnoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Alumno> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alumno> obtenerPorId(@PathVariable Long id) {
        return service.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/curso/{cursoId}")
    public List<Alumno> listarPorCurso(@PathVariable Long cursoId) {
        return service.listarPorCurso(cursoId);
    }

    @PostMapping
    public Alumno crear(@RequestBody Alumno alumno) {
        return service.crear(alumno);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alumno> actualizar(@PathVariable Long id, @RequestBody Alumno datos) {
        return ResponseEntity.ok(service.actualizar(id, datos));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
