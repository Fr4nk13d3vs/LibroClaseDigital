package cl.duoc.colegio.ms_mensajeria.service;

import cl.duoc.colegio.ms_mensajeria.model.Mensaje;
import cl.duoc.colegio.ms_mensajeria.repository.MensajeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MensajeService {

    private final MensajeRepository repository;

    public MensajeService(MensajeRepository repository) {
        this.repository = repository;
    }

    public List<Mensaje> listarTodos() {
        return repository.findAll();
    }

    public Optional<Mensaje> obtenerPorId(Long id) {
        return repository.findById(id);
    }

    public List<Mensaje> listarRecibidos(Long destinatarioId) {
        return repository.findByDestinatarioId(destinatarioId);
    }

    public List<Mensaje> listarEnviados(Long remitenteId) {
        return repository.findByRemitenteId(remitenteId);
    }

    public List<Mensaje> listarNoLeidos(Long destinatarioId) {
        return repository.findByDestinatarioIdAndLeido(destinatarioId, false);
    }

    public Mensaje enviar(Mensaje mensaje) {
        mensaje.setLeido(false);
        return repository.save(mensaje);
    }

    public Mensaje marcarLeido(Long id) {
        Mensaje mensaje = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mensaje no encontrado con id: " + id));
        mensaje.setLeido(true);
        return repository.save(mensaje);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
