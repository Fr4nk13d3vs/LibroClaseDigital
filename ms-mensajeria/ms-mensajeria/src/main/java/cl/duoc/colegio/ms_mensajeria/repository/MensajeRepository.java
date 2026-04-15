package cl.duoc.colegio.ms_mensajeria.repository;

import cl.duoc.colegio.ms_mensajeria.model.Mensaje;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MensajeRepository extends JpaRepository<Mensaje, Long> {
    List<Mensaje> findByDestinatarioId(Long destinatarioId);
    List<Mensaje> findByRemitenteId(Long remitenteId);
    List<Mensaje> findByDestinatarioIdAndLeido(Long destinatarioId, Boolean leido);
}
