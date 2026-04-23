package cesde.migaja.migajaApp.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cesde.migaja.migajaApp.Models.MedioPago;
import cesde.migaja.migajaApp.servicios.Serviciomediodepago;

@RestController
@RequestMapping("/apiMigaja/v1/medioPago")
public class ControladorMedioPago {
    @Autowired 
    Serviciomediodepago servicio;

    public ResponseEntity<?> guardar_mediopago(@RequestBody MedioPago datosmediopago){
        return ResponseEntity.ok(servicio.guardar_medioPago(datosmediopago));
    }

    public ResponseEntity<?> listar_mediopago(){
        return ResponseEntity.ok(servicio.listar_mediopago());
    }
}
 