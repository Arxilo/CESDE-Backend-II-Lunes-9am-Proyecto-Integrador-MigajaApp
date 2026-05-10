package cesde.migaja.migajaApp.servicios;

import java.util.List;
import java.util.Optional;

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

        if (datosGastos.getDescripcion() == null || datosGastos.getDescripcion().isBlank()
                || datosGastos.getDescripcion().isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "La descripcion del gasto es obligatorio, revisa por favor");
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

    public Gasto actualizarGasto(Long id, Gasto gasto) {
        Optional<Gasto> gastoBusqueda = repositorio.findById(id);

        if (gastoBusqueda.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Gasto no se encontro");
        } else {
            Gasto gastoEncontrado = gastoBusqueda.get();
            gastoEncontrado.setDescripcion(gasto.getDescripcion());
            gastoEncontrado.setFecha(gasto.getFecha());
            gastoEncontrado.setMonto(gasto.getMonto());
            gastoEncontrado.setImagen(gasto.getImagen());
            gastoEncontrado.setMoneda(gasto.getMoneda());
            gastoEncontrado.setMetodoPago(gasto.getMetodoPago());
            gastoEncontrado.setLugar(gasto.getLugar());
            gastoEncontrado.setEsRecurrente(gasto.getEsRecurrente());
            gastoEncontrado.setTipoGasto(gasto.getTipoGasto());
            gastoEncontrado.setImpactoFinanciero(gasto.getImpactoFinanciero());
            gastoEncontrado.setActivo(gasto.getActivo());
            gastoEncontrado.setObservaciones(gasto.getObservaciones());

            return repositorio.save(gastoEncontrado);
        }
    }

    public Boolean eliminarGasto(Long id) {
        Optional<Gasto> gasto = repositorio.findById(id);
        if (gasto.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Gasto no se encontro");
        } else {
            repositorio.deleteById(id);
            return true;
        }
    }

    public Gasto buscarGasto(Long id) {
        Optional<Gasto> gasto = repositorio.findById(id);
        if (gasto.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Gasto no se encontro");
        } else {
            return gasto.get();
        }
    }
}
