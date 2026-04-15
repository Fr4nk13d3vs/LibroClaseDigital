package cl.duoc.colegio.ms_mensajeria.model;

import jakarta.persistence.*;

@Entity
@Table(name = "mensajes")
public class Mensaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "remitente_id", nullable = false)
    private Long remitenteId;

    @Column(name = "destinatario_id", nullable = false)
    private Long destinatarioId;

    @Column(nullable = false, length = 150)
    private String asunto;

    @Column(nullable = false, length = 2000)
    private String contenido;

    @Column(nullable = false, length = 20)
    private String fecha;

    @Column(nullable = false)
    private Boolean leido = false;

    public Mensaje() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getRemitenteId() { return remitenteId; }
    public void setRemitenteId(Long remitenteId) { this.remitenteId = remitenteId; }

    public Long getDestinatarioId() { return destinatarioId; }
    public void setDestinatarioId(Long destinatarioId) { this.destinatarioId = destinatarioId; }

    public String getAsunto() { return asunto; }
    public void setAsunto(String asunto) { this.asunto = asunto; }

    public String getContenido() { return contenido; }
    public void setContenido(String contenido) { this.contenido = contenido; }

    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }

    public Boolean getLeido() { return leido; }
    public void setLeido(Boolean leido) { this.leido = leido; }
}
