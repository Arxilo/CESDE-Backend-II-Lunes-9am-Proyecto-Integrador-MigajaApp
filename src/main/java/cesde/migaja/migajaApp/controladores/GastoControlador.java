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

import cesde.migaja.migajaApp.Models.Gasto;
import cesde.migaja.migajaApp.servicios.GastoServicio;

@RestController
@RequestMapping("/migaja/v1/gasto")
public class GastoControlador {

    @Autowired
    private GastoServicio servicio;

    @PostMapping
    public ResponseEntity<?> postMethodName(@RequestBody Gasto datos) {
        return ResponseEntity.status(HttpStatus.OK).body(
                servicio.guardar_gasto(datos));
    }

    @GetMapping
    public ResponseEntity<?> controladorListarTodo() {
        return ResponseEntity.status(HttpStatus.OK).body(
                servicio.listar_gastos());
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> putMethodName(@PathVariable Integer id, @RequestBody Gasto gasto) {

        return ResponseEntity.status(HttpStatus.OK).body(servicio.actualizarGasto(id, gasto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> eliminarGasto(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(servicio.eliminarGasto(id));
    }

    @GetMapping("/buscarPorId/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(servicio.buscarGasto(id));
    }

}
