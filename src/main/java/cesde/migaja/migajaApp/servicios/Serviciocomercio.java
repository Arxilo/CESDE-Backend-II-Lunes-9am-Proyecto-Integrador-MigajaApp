package cesde.migaja.migajaApp.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import cesde.migaja.migajaApp.Models.Comercio;
import cesde.migaja.migajaApp.repositorios.Icomercio;
import org.springframework.web.server.ResponseStatusException;

@Service
public class Serviciocomercio {

    @Autowired
    private Icomercio repositoriocomercio;

    public Comercio guardar_comercio(Comercio datoscomercio) {
        if (datoscomercio.getNombre().isEmpty() || datoscomercio.getNombre().isBlank()
                || datoscomercio.getNombre() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El nombre del comercio no puede estar vacío");
        }
        return repositoriocomercio.save(datoscomercio);
    }

    public List<Comercio> listar_comercio() {
        return repositoriocomercio.findAll();
    }
}