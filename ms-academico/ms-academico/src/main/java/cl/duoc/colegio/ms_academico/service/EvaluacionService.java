package cl.duoc.colegio.ms_academico.service;

import cl.duoc.colegio.ms_academico.model.Evaluacion;
import cl.duoc.colegio.ms_academico.repository.EvaluacionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EvaluacionService {

    private final EvaluacionRepository repository;

    public EvaluacionService(EvaluacionRepository repository) {
        this.repository = repository;
    }

    public List<Evaluacion> listarTodas() {
        return repository.findAll();
    }

    public Optional<Evaluacion> obtenerPorId(Long id) {
        return repository.findById(id);
    }

    public List<Evaluacion> listarPorAlumno(Long alumnoId) {
        return repository.findByAlumnoId(alumnoId);
    }

    public List<Evaluacion> listarPorAsignatura(Long asignaturaId) {
        return repository.findByAsignaturaId(asignaturaId);
    }

    public Evaluacion crear(Evaluacion evaluacion) {
        return repository.save(evaluacion);
    }

    public Evaluacion actualizar(Long id, Evaluacion datos) {
        Evaluacion evaluacion = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Evaluacion no encontrada con id: " + id));
        evaluacion.setNombre(datos.getNombre());
        evaluacion.setTipo(datos.getTipo());
        evaluacion.setFecha(datos.getFecha());
        evaluacion.setNota(datos.getNota());
        evaluacion.setAlumno(datos.getAlumno());
        evaluacion.setAsignatura(datos.getAsignatura());
        return repository.save(evaluacion);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
