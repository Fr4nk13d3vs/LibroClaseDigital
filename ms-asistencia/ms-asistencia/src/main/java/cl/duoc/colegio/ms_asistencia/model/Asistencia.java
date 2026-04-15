package cl.duoc.colegio.ms_asistencia.model;

import jakarta.persistence.*;

@Entity
@Table(name = "asistencias")
public class Asistencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "alumno_id", nullable = false)
    private Long alumnoId;

    @Column(nullable = false, length = 10)
    private String fecha;

    @Column(nullable = false)
    private Boolean presente;

    @Column(length = 255)
    private String justificacion;

    public Asistencia() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getAlumnoId() { return alumnoId; }
    public void setAlumnoId(Long alumnoId) { this.alumnoId = alumnoId; }

    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }

    public Boolean getPresente() { return presente; }
    public void setPresente(Boolean presente) { this.presente = presente; }

    public String getJustificacion() { return justificacion; }
    public void setJustificacion(String justificacion) { this.justificacion = justificacion; }
}
