package cl.duoc.colegio.ms_academico.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cursos")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String nombre;

    @Column(nullable = false, length = 20)
    private String nivel;

    @Column(nullable = false, length = 5)
    private String seccion;

    @Column(nullable = false)
    private Integer anio;

    public Curso() {}

    public Curso(String nombre, String nivel, String seccion, Integer anio) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.seccion = seccion;
        this.anio = anio;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getNivel() { return nivel; }
    public void setNivel(String nivel) { this.nivel = nivel; }

    public String getSeccion() { return seccion; }
    public void setSeccion(String seccion) { this.seccion = seccion; }

    public Integer getAnio() { return anio; }
    public void setAnio(Integer anio) { this.anio = anio; }
}
