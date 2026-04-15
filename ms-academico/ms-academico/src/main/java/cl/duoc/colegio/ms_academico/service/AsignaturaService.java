package cl.duoc.colegio.ms_academico.service;

import cl.duoc.colegio.ms_academico.model.Asignatura;
import cl.duoc.colegio.ms_academico.repository.AsignaturaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AsignaturaService {

    private final AsignaturaRepository repository;

    public AsignaturaService(AsignaturaRepository repository) {
        this.repository = repository;
    }

    public List<Asignatura> listarTodas() {
        return repository.findAll();
    }

    public Optional<Asignatura> obtenerPorId(Long id) {
        return repository.findById(id);
    }

    public Optional<Asignatura> obtenerPorCodigo(String codigo) {
        return repository.findByCodigo(codigo);
    }

    public Asignatura crear(Asignatura asignatura) {
        return repository.save(asignatura);
    }

    public Asignatura actualizar(Long id, Asignatura datos) {
        Asignatura asignatura = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Asignatura no encontrada con id: " + id));
        asignatura.setCodigo(datos.getCodigo());
        asignatura.setNombre(datos.getNombre());
        asignatura.setDescripcion(datos.getDescripcion());
        return repository.save(asignatura);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
