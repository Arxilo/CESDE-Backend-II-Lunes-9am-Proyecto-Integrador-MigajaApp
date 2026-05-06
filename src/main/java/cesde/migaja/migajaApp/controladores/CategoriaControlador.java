package cesde.migaja.migajaApp.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cesde.migaja.migajaApp.Models.Categoria;
import cesde.migaja.migajaApp.servicios.CategoriaServicio;

@RestController
@RequestMapping("/migaja/v1/categoria")
public class CategoriaControlador {

    @Autowired
    private CategoriaServicio servicio;

    @PostMapping
    public ResponseEntity<?> guardarCategoria(@RequestBody Categoria datos) {
        return ResponseEntity.status(HttpStatus.OK).body(
                servicio.guardarCategoria(datos));
    }

    @GetMapping
    public ResponseEntity<?> listarCategorias() {
        return ResponseEntity.status(HttpStatus.OK).body(
                servicio.listarCategorias());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editarCategoria(@RequestBody Categoria datos, @PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(
                servicio.editarCategoria(datos, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarCategoria(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(
                servicio.eliminarCategoria(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerCategoriaPorId(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(
                servicio.obtenerCategoriaPorId(id));
    }


}

