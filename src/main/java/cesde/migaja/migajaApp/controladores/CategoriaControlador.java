package cesde.migaja.migajaApp.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cesde.migaja.migajaApp.Models.CategoriaModel;
import cesde.migaja.migajaApp.servicios.CategoriaServicio;

@RestController
@RequestMapping("/migaja/v1/categoria")
public class CategoriaControlador {

    @Autowired
    private CategoriaServicio servicio;

    @PostMapping
    public ResponseEntity<?> guardarCategoria(@RequestBody CategoriaModel datos) {
        return ResponseEntity.status(HttpStatus.OK).body(
                servicio.guardarCategoria(datos));
    }

    @GetMapping
    public ResponseEntity<?> listarCategorias() {
        return ResponseEntity.status(HttpStatus.OK).body(
                servicio.listarCategorias());
    }
}