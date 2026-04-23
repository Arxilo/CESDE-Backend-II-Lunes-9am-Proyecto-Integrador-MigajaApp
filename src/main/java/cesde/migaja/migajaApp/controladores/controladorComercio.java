package cesde.migaja.migajaApp.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/apiMigaja/v1/comercios")
public class controladorcomercio {

    @aUtowired
    Serviciocomercio servicio;

    public ResponseEntity<?> servicio.guardar_comercio(@RequestBody Comercio datoscomercio) {
            return ResponseEntity.ok(servicio.guardar_comercio(datoscomercio));
    }

    public ResponseEntity<?> servicio.listar_comercio() {
        return ResponseEntity.ok(servicio.listar_comercio());
    } 

}