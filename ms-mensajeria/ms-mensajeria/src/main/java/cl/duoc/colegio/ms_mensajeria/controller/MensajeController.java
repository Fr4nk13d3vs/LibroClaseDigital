package cl.duoc.colegio.ms_mensajeria.controller;

import cl.duoc.colegio.ms_mensajeria.model.Mensaje;
import cl.duoc.colegio.ms_mensajeria.service.MensajeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mensajes")
public class MensajeController {

    private final MensajeService service;

    public MensajeController(MensajeService service) {
        this.service = service;
    }

    @GetMapping
    public List<Mensaje> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mensaje> obtenerPorId(@PathVariable Long id) {
        return service.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/recibidos/{destinatarioId}")
    public List<Mensaje> listarRecibidos(@PathVariable Long destinatarioId) {
        return service.listarRecibidos(destinatarioId);
    }

    @GetMapping("/enviados/{remitenteId}")
    public List<Mensaje> listarEnviados(@PathVariable Long remitenteId) {
        return service.listarEnviados(remitenteId);
    }

    @GetMapping("/no-leidos/{destinatarioId}")
    public List<Mensaje> listarNoLeidos(@PathVariable Long destinatarioId) {
        return service.listarNoLeidos(destinatarioId);
    }

    @PostMapping
    public Mensaje enviar(@RequestBody Mensaje mensaje) {
        return service.enviar(mensaje);
    }

    @PatchMapping("/{id}/leer")
    public ResponseEntity<Mensaje> marcarLeido(@PathVariable Long id) {
        return ResponseEntity.ok(service.marcarLeido(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
