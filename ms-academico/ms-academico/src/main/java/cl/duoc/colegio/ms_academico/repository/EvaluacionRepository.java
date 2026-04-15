package cl.duoc.colegio.ms_academico.repository;

import cl.duoc.colegio.ms_academico.model.Evaluacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EvaluacionRepository extends JpaRepository<Evaluacion, Long> {
    List<Evaluacion> findByAlumnoId(Long alumnoId);
    List<Evaluacion> findByAsignaturaId(Long asignaturaId);
}
