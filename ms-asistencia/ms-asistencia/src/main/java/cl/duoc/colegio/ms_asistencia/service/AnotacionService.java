package cl.duoc.colegio.ms_asistencia.service;

import cl.duoc.colegio.ms_asistencia.model.Anotacion;
import cl.duoc.colegio.ms_asistencia.repository.AnotacionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnotacionService {

    private final AnotacionRepository repository;

    public AnotacionService(AnotacionRepository repository) {
        this.repository = repository;
    }

    public List<Anotacion> listarTodas() {
        return repository.findAll();
    }

    public Optional<Anotacion> obtenerPorId(Long id) {
        return repository.findById(id);
    }

    public List<Anotacion> listarPorAlumno(Long alumnoId) {
        return repository.findByAlumnoId(alumnoId);
    }

    public List<Anotacion> listarPorTipo(String tipo) {
        return repository.findByTipo(tipo);
    }

    public Anotacion crear(Anotacion anotacion) {
        return repository.save(anotacion);
    }

    public Anotacion actualizar(Long id, Anotacion datos) {
        Anotacion anotacion = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Anotacion no encontrada con id: " + id));
        anotacion.setAlumnoId(datos.getAlumnoId());
        anotacion.setTipo(datos.getTipo());
        anotacion.setDescripcion(datos.getDescripcion());
        anotacion.setFecha(datos.getFecha());
        anotacion.setProfesorId(datos.getProfesorId());
        return repository.save(anotacion);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
