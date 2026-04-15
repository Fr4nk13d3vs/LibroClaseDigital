package cl.duoc.colegio.ms_asistencia.model;

import jakarta.persistence.*;

@Entity
@Table(name = "anotaciones")
public class Anotacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "alumno_id", nullable = false)
    private Long alumnoId;

    @Column(nullable = false, length = 20)
    private String tipo;

    @Column(nullable = false, length = 500)
    private String descripcion;

    @Column(nullable = false, length = 10)
    private String fecha;

    @Column(name = "profesor_id", nullable = false)
    private Long profesorId;

    public Anotacion() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getAlumnoId() { return alumnoId; }
    public void setAlumnoId(Long alumnoId) { this.alumnoId = alumnoId; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }

    public Long getProfesorId() { return profesorId; }
    public void setProfesorId(Long profesorId) { this.profesorId = profesorId; }
}
