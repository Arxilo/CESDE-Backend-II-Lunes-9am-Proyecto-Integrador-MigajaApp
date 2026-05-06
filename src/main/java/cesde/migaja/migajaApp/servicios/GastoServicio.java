package cesde.migaja.migajaApp.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import cesde.migaja.migajaApp.Models.Gasto;
import cesde.migaja.migajaApp.repositorios.GastoRepository;

@Service
public class GastoServicio {
    @Autowired
    private GastoRepository repositorio;

    public Gasto guardar_gasto(Gasto datosGastos) {

        if (datosGastos.getDescripcion() == null || datosGastos.getDescripcion().isBlank()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "La descripcion del gasto es obligatorio, revisa por favor");
        }
        
        if (datosGastos.getMonto() == null) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "El monto es obligatorio");
        }

        if (datosGastos.getMonto().isNaN()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "El monto debe de ser un numero");
        }

        return repositorio.save(datosGastos);
    }

    public List<Gasto> listar_gastos() {
        return repositorio.findAll();
    }
}
