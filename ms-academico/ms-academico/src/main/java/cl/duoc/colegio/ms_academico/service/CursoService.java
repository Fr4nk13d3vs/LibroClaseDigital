package cl.duoc.colegio.ms_academico.service;

import cl.duoc.colegio.ms_academico.model.Curso;
import cl.duoc.colegio.ms_academico.repository.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    private final CursoRepository repository;

    public CursoService(CursoRepository repository) {
        this.repository = repository;
    }

    public List<Curso> listarTodos() {
        return repository.findAll();
    }

    public Optional<Curso> obtenerPorId(Long id) {
        return repository.findById(id);
    }

    public List<Curso> listarPorAnio(Integer anio) {
        return repository.findByAnio(anio);
    }

    public Curso crear(Curso curso) {
        return repository.save(curso);
    }

    public Curso actualizar(Long id, Curso datos) {
        Curso curso = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado con id: " + id));
        curso.setNombre(datos.getNombre());
        curso.setNivel(datos.getNivel());
        curso.setSeccion(datos.getSeccion());
        curso.setAnio(datos.getAnio());
        return repository.save(curso);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
