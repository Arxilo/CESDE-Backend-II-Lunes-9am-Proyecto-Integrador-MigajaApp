package cesde.migaja.migajaApp.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import cesde.migaja.migajaApp.Models.Categoria;
import cesde.migaja.migajaApp.repositorios.CategoriaRepository;

@Service
public class CategoriaServicio {

    @Autowired
    private CategoriaRepository repositorio;

    public Categoria guardarCategoria(Categoria datosCategoria) {

        // Validar que el nombre no esté vacío
        if (datosCategoria.getNombre() == null ||
            datosCategoria.getNombre().isEmpty() ||
            datosCategoria.getNombre().isBlank()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "El nombre de la categoría es obligatorio");

        }

        if (datosCategoria.getFechaCreacion() == null) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "La fecha de creación es obligatoria");
        }

        if (datosCategoria.getResponsable() == null ||
            datosCategoria.getResponsable().isEmpty() ||
            datosCategoria.getResponsable().isBlank()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "El responsable de la categoría es obligatorio");
        }

        if (datosCategoria.getPrioridad() == null) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "La prioridad de la categoría es obligatoria");
        }

        if (datosCategoria.getEstado() == null) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "El estado de la categoría es obligatorio");
        }

        if (datosCategoria.getColor() != null &&
            datosCategoria.getColor().length() > 20) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "El color de la categoría no puede tener más de 20 caracteres");
        }

        if (datosCategoria.getIcono() != null &&
            datosCategoria.getIcono().length() > 50) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "El icono de la categoría no puede tener más de 50 caracteres");
        }

        if (datosCategoria.getJustificacion() != null &&
            datosCategoria.getJustificacion().length() > 200) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "La justificación de la categoría no puede tener más de 200 caracteres");
        }

        if (datosCategoria.getDescripcion() != null &&
            datosCategoria.getDescripcion().length() > 500) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "La descripción de la categoría no puede tener más de 500 caracteres");
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

    public List<Categoria> listarCategorias() {
        return repositorio.findAll();
    }

    public Categoria editarCategoria(Categoria datosCategoria, Integer id) {
        Optional<Categoria> categoriaExistente = repositorio.findById(id);
        if (categoriaExistente.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "La categoría no existe");
        }
        else {
            Categoria categoriaEncontrada = categoriaExistente.get();
            categoriaEncontrada.setNombre(datosCategoria.getNombre());
            categoriaEncontrada.setFechaCreacion(datosCategoria.getFechaCreacion());
            categoriaEncontrada.setResponsable(datosCategoria.getResponsable());
            categoriaEncontrada.setJustificacion(datosCategoria.getJustificacion());
            categoriaEncontrada.setDescripcion(datosCategoria.getDescripcion());
            categoriaEncontrada.setPrioridad(datosCategoria.getPrioridad());
            categoriaEncontrada.setColor(datosCategoria.getColor());
            categoriaEncontrada.setIcono(datosCategoria.getIcono());
            categoriaEncontrada.setEstado(datosCategoria.getEstado());
            return repositorio.save(categoriaEncontrada);
            

        }

    }

    public boolean eliminarCategoria(Integer id) {
        Optional<Categoria> categoriaExistente = repositorio.findById(id);
        if (categoriaExistente.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "La categoría no existe");
        }
        else {
            repositorio.deleteById(id);
            return true;
        }
    }

    public Categoria obtenerCategoriaPorId(Integer id) {
        Optional<Categoria> categoriaExistente = repositorio.findById(id);
        if (categoriaExistente.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "La categoría no existe");
        }

        
        else {
            return categoriaExistente.get();
        }
    }

    //sdjhfu


}