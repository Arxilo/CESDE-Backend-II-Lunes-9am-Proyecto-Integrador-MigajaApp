package cesde.migaja.migajaApp.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cesde.migaja.migajaApp.Models.Comercio;
import cesde.migaja.migajaApp.servicios.Serviciocomercio;

@RestController
@RequestMapping("/apiMigaja/v1/comercios")
public class controladorComercio {

    @Autowired
    Serviciocomercio servicio;

    public ResponseEntity<?> guardar_comercio(@RequestBody Comercio datoscomercio) {
            return ResponseEntity.ok(servicio.guardar_comercio(datoscomercio));
    }

    public ResponseEntity<?> listar_comercio() {
        return ResponseEntity.ok(servicio.listar_comercio());
    } 

}