package cl.duoc.colegio.ms_academico.repository;

import cl.duoc.colegio.ms_academico.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CursoRepository extends JpaRepository<Curso, Long> {
    List<Curso> findByAnio(Integer anio);
}
