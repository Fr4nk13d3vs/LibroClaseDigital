package cl.duoc.colegio.ms_academico.service;

import cl.duoc.colegio.ms_academico.model.Alumno;
import cl.duoc.colegio.ms_academico.repository.AlumnoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlumnoService {

    private final AlumnoRepository repository;

    public AlumnoService(AlumnoRepository repository) {
        this.repository = repository;
    }

    public List<Alumno> listarTodos() {
        return repository.findAll();
    }

    public Optional<Alumno> obtenerPorId(Long id) {
        return repository.findById(id);
    }

    public Optional<Alumno> obtenerPorRut(String rut) {
        return repository.findByRut(rut);
    }

    public List<Alumno> listarPorCurso(Long cursoId) {
        return repository.findByCursoId(cursoId);
    }

    public Alumno crear(Alumno alumno) {
        return repository.save(alumno);
    }

    public Alumno actualizar(Long id, Alumno datos) {
        Alumno alumno = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Alumno no encontrado con id: " + id));
        alumno.setRut(datos.getRut());
        alumno.setNombre(datos.getNombre());
        alumno.setApellido(datos.getApellido());
        alumno.setFechaNacimiento(datos.getFechaNacimiento());
        alumno.setCurso(datos.getCurso());
        return repository.save(alumno);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
