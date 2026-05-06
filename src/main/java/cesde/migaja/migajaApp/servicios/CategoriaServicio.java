package cesde.migaja.migajaApp.servicios;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import cesde.migaja.migajaApp.Models.CategoriaModel;
import cesde.migaja.migajaApp.repositorios.CategoriaRepository;

@Service
public class CategoriaServicio {

    @Autowired
    private CategoriaRepository repositorio;

    public CategoriaModel guardarCategoria(CategoriaModel datosCategoria) {

        // Validar que el nombre no esté vacío
        if (datosCategoria.getNombre() == null ||
            datosCategoria.getNombre().isEmpty() ||
            datosCategoria.getNombre().isBlank()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "El nombre de la categoría es obligatorio");
        }

        // Validar que el nombre tenga al menos 6 caracteres
        if (datosCategoria.getNombre().length() < 6) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "El nombre de la categoría debe tener al menos 6 caracteres");
        }

        // Si pasó todas las validaciones, guardar
        return repositorio.save(datosCategoria);
    }

    public List<CategoriaModel> listarCategorias() {
        return repositorio.findAll();
    }
}