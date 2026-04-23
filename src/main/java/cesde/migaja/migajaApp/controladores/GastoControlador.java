package cesde.migaja.migajaApp.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

}
