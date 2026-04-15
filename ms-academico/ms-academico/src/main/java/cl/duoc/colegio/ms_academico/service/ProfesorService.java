package cl.duoc.colegio.ms_academico.service;

import cl.duoc.colegio.ms_academico.model.Profesor;
import cl.duoc.colegio.ms_academico.repository.ProfesorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfesorService {

    private final ProfesorRepository repository;

    public ProfesorService(ProfesorRepository repository) {
        this.repository = repository;
    }

    public List<Profesor> listarTodos() {
        return repository.findAll();
    }

    public Optional<Profesor> obtenerPorId(Long id) {
        return repository.findById(id);
    }

    public Optional<Profesor> obtenerPorRut(String rut) {
        return repository.findByRut(rut);
    }

    public Profesor crear(Profesor profesor) {
        return repository.save(profesor);
    }

    public Profesor actualizar(Long id, Profesor datos) {
        Profesor profesor = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Profesor no encontrado con id: " + id));
        profesor.setRut(datos.getRut());
        profesor.setNombre(datos.getNombre());
        profesor.setApellido(datos.getApellido());
        profesor.setEspecialidad(datos.getEspecialidad());
        return repository.save(profesor);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
