package cesde.migaja.migajaApp.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cesde.migaja.migajaApp.servicios.Serviciocomercio;
import cesde.migaja.migajaApp.Models.Comercio;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;





@RestController
@RequestMapping("/apiMigaja/v1/comercios")
public class controladorComercio {

    @Autowired
    Serviciocomercio servicio;

    @PostMapping
    public ResponseEntity<?> guardar_comercio(@RequestBody Comercio datoscomercio) {
            return ResponseEntity.ok(servicio.guardar_comercio(datoscomercio));
    }

    @GetMapping
    public ResponseEntity<?> listar_comercio() {
        return ResponseEntity.ok(servicio.listar_comercio());
    } 

    // metodo actualizar comercio
    @PutMapping("/{id}")
    public ResponseEntity<?> controlador_editar(@PathVariable Integer id, @RequestBody Comercio datoscomercio) {
        
        
        return ResponseEntity.status(HttpStatus.OK).body(servicio.actualizar_comercio(id, datoscomercio));
    }

    // metodo eliminar comercio
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar_comercio(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(servicio.eliminar_comercio(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscar_comercio(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(servicio.buscar_comercio(id));
        
    }
    

}
