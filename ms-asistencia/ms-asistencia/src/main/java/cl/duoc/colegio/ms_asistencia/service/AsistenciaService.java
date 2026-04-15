package cl.duoc.colegio.ms_asistencia.service;

import cl.duoc.colegio.ms_asistencia.model.Asistencia;
import cl.duoc.colegio.ms_asistencia.repository.AsistenciaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AsistenciaService {

    private final AsistenciaRepository repository;

    public AsistenciaService(AsistenciaRepository repository) {
        this.repository = repository;
    }

    public List<Asistencia> listarTodas() {
        return repository.findAll();
    }

    public Optional<Asistencia> obtenerPorId(Long id) {
        return repository.findById(id);
    }

    public List<Asistencia> listarPorAlumno(Long alumnoId) {
        return repository.findByAlumnoId(alumnoId);
    }

    public List<Asistencia> listarPorFecha(String fecha) {
        return repository.findByFecha(fecha);
    }

    public Asistencia crear(Asistencia asistencia) {
        return repository.save(asistencia);
    }

    public Asistencia actualizar(Long id, Asistencia datos) {
        Asistencia asistencia = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Asistencia no encontrada con id: " + id));
        asistencia.setAlumnoId(datos.getAlumnoId());
        asistencia.setFecha(datos.getFecha());
        asistencia.setPresente(datos.getPresente());
        asistencia.setJustificacion(datos.getJustificacion());
        return repository.save(asistencia);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
