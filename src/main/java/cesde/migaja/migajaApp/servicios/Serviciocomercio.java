package cesde.migaja.migajaApp.servicios;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import cesde.migaja.migajaApp.Models.Comercio;
import cesde.migaja.migajaApp.repositorios.Icomercio;
import java.util.Optional;

@Service
public class Serviciocomercio {

    @Autowired
    private Icomercio repositoriocomercio;

    public Comercio guardar_comercio(Comercio datoscomercio) {
        if (datoscomercio.getNombre() == null || datoscomercio.getNombre().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El nombre del comercio no puede estar vacío");
        }
        if (datoscomercio.getNit() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El nit del comercio no puede estar vacío");
        }
        if (datoscomercio.getDireccion() == null || datoscomercio.getDireccion().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La dirección del comercio no puede estar vacía");
        }
        if (datoscomercio.getTelefono() == null || datoscomercio.getTelefono().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El teléfono del comercio no puede estar vacío");
        }
        if (datoscomercio.getCorreo() == null || datoscomercio.getCorreo().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El correo del comercio no puede estar vacío");
        }
        if (datoscomercio.getRepresentanteLegal() == null || datoscomercio.getRepresentanteLegal().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El representante legal del comercio no puede estar vacío");
        }
        if (datoscomercio.getActividad() == null || datoscomercio.getActividad().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La actividad del comercio no puede estar vacía");
        }

        return repositoriocomercio.save(datoscomercio);
    }

    public List<Comercio> listar_comercio() {
        return repositoriocomercio.findAll();
    }

    public Comercio actualizar_comercio(Integer id, Comercio datoscomercio) {
        Optional<Comercio> comercioBuscado = repositoriocomercio.findById(id);

        if (comercioBuscado.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El comercio con el id " + id + " no existe");
        }

        // Validaciones antes de actualizar
        if (datoscomercio.getNombre() == null || datoscomercio.getNombre().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El nombre del comercio no puede estar vacío");
        }
        if (datoscomercio.getNit() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El nit del comercio no puede estar vacío");
        }
        if (datoscomercio.getDireccion() == null || datoscomercio.getDireccion().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La dirección del comercio no puede estar vacía");
        }
        if (datoscomercio.getTelefono() == null || datoscomercio.getTelefono().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El teléfono del comercio no puede estar vacío");
        }
        if (datoscomercio.getCorreo() == null || datoscomercio.getCorreo().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El correo del comercio no puede estar vacío");
        }
        if (datoscomercio.getRepresentanteLegal() == null || datoscomercio.getRepresentanteLegal().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El representante legal del comercio no puede estar vacío");
        }
        if (datoscomercio.getActividad() == null || datoscomercio.getActividad().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La actividad del comercio no puede estar vacía");
        }

        Comercio comercioActualizado = comercioBuscado.get();
        comercioActualizado.setNombre(datoscomercio.getNombre());
        comercioActualizado.setNit(datoscomercio.getNit());
        comercioActualizado.setDireccion(datoscomercio.getDireccion());
        comercioActualizado.setTelefono(datoscomercio.getTelefono());
        comercioActualizado.setCorreo(datoscomercio.getCorreo());
        comercioActualizado.setSitioWeb(datoscomercio.getSitioWeb());
        comercioActualizado.setRepresentanteLegal(datoscomercio.getRepresentanteLegal());
        comercioActualizado.setActividad(datoscomercio.getActividad());

        return repositoriocomercio.save(comercioActualizado);
    }

    public boolean eliminar_comercio(Integer id) {
        Optional<Comercio> comercioBuscado = repositoriocomercio.findById(id);

        if (comercioBuscado.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El comercio con el id " + id + " no existe");

        }else{
            repositoriocomercio.deleteById(id);
            return true;
        }
    }

    public Comercio buscar_comercio(Integer id) {
        Optional<Comercio> comercioBuscado = repositoriocomercio.findById(id);

        if (comercioBuscado.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El comercio con el id " + id + " no existe");

        }else{
            return comercioBuscado.get();
        }
    }

}