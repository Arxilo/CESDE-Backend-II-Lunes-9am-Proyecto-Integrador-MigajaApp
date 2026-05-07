package cesde.migaja.migajaApp.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import cesde.migaja.migajaApp.Models.MedioPago;
import cesde.migaja.migajaApp.repositorios.Imediodepagorepositorio;

@Service
public class Serviciomediodepago {
    @Autowired
    private Imediodepagorepositorio mediodepagorepositorio;

    public MedioPago guardar_medioPago(MedioPago datosmediopago) {

        if (datosmediopago.getNombre().isEmpty() || datosmediopago.getNombre().isBlank()
                || datosmediopago.getNombre() == null) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Dato requerido");
        }

        if (datosmediopago.getFranquicia() == null) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Dato requerido");
        }

        if (datosmediopago.getEstado() == null) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Dato requerido");
        }
        return mediodepagorepositorio.save(datosmediopago);
    }

    public List<MedioPago> listar_mediopago() {
        return mediodepagorepositorio.findAll();
    }

    public MedioPago actualizarMedioPago(Integer id, MedioPago datos) {
        Optional<MedioPago> buscarmediopago = mediodepagorepositorio.findById(id);
        if (buscarmediopago.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "No encontrado");
        } else {
            MedioPago medioencontrado = buscarmediopago.get();
            medioencontrado.setNombre(datos.getNombre());
            medioencontrado.setFranquicia(datos.getFranquicia());
            medioencontrado.setEstado(datos.getEstado());
            return mediodepagorepositorio.save(medioencontrado);
        }
    }

    public boolean eliminarmediodepago(Integer id) {
        Optional<MedioPago> buscarmediopago = mediodepagorepositorio.findById(id);
        if (buscarmediopago.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "No encontrado");
        } else {

            mediodepagorepositorio.deleteById(id);
            return true;
        }
    }

    public MedioPago buscar_medio_pago_por_id(Integer id) {
        Optional<MedioPago> buscarmediopago = mediodepagorepositorio.findById(id);
        if (buscarmediopago.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "No encontrado");
        } else {

            return buscarmediopago.get();
        }
    }
}