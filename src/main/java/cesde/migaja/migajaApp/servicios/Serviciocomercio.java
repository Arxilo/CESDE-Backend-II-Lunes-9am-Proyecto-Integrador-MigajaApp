package cesde.migaja.migajaApp.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cesde.migaja.migajaApp.Models.Comercio;
import cesde.migaja.migajaApp.repositorios.repositoriocomercio


@service
    public class serviciocomercio {

    @Autowired
    private repositoriocomercio repositoriocomercio;

    public Comercio guardar_comercio(Comercio datoscomercio) {
        if (datoscomercio.getNombre().isEmpty() || datoscomercio.getNombre().isBlank() || datoscomercio.getNombre() == null) {
            throw new responseStatusException(HttpStatus.BAD_REQUEST, "El nombre del comercio no puede estar vacío");
        }
        return repositoriocomercio.save(datoscomercio);
    }

    public List<Comercio> listar_comercio() {
        return repositoriocomercio.findAll();
    }
}