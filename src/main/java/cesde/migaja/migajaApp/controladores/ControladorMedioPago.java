package cesde.migaja.migajaApp.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cesde.migaja.migajaApp.Models.MedioPago;
import cesde.migaja.migajaApp.servicios.Serviciomediodepago;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/apiMigaja/v1/medioPago")
public class ControladorMedioPago {
    @Autowired
    Serviciomediodepago servicio;

    @PostMapping
    public ResponseEntity<?> guardar_mediopago(@RequestBody MedioPago datosmediopago) {
        return ResponseEntity.ok(servicio.guardar_medioPago(datosmediopago));
    }

    @GetMapping
    public ResponseEntity<?> listar_mediopago() {
        return ResponseEntity.ok(servicio.listar_mediopago());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> controlador_editar(@PathVariable Integer id, @RequestBody MedioPago datos) {
        return ResponseEntity.status(HttpStatus.OK).body(
                servicio.actualizarMedioPago(id, datos));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> controlador_eliminar(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(
                servicio.eliminarmediodepago(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> controlador_buscar_por_id(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(
                servicio.buscar_medio_pago_por_id(id));
    }
    
}