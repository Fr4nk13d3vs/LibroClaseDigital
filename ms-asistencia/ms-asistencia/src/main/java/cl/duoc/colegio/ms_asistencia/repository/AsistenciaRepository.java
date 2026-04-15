package cl.duoc.colegio.ms_asistencia.repository;

import cl.duoc.colegio.ms_asistencia.model.Asistencia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AsistenciaRepository extends JpaRepository<Asistencia, Long> {
    List<Asistencia> findByAlumnoId(Long alumnoId);
    List<Asistencia> findByFecha(String fecha);
}
