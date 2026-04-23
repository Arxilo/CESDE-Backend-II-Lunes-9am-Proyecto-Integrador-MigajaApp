package cesde.migaja.migajaApp.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cesde.migaja.migajaApp.Models.Usuario;
import cesde.migaja.migajaApp.servicios.UsuarioServicio;

@RestController
@RequestMapping("/apiMigaja/v1/usuarios")
public class ControladorUsuario {

    @Autowired
    UsuarioServicio servicio;

    // Por cada servicio programo un metodo para recibir y enviar respuestas al cliente

    // funcion controladora para el servicio de guardar usuario
    public ResponseEntity<?>controladorGuardar(@RequestBody Usuario datosUsuario){
        return ResponseEntity.status(HttpStatus.OK).body(
            servicio.guardar_Usuario(datosUsuario)
        );
    }

    // funcion controladora para el servicio de listar usuario
    public ResponseEntity<?>controladorListar(){
        return ResponseEntity.status(HttpStatus.OK).body(
            servicio.listar_usuarios()
            
        );
    }


}
