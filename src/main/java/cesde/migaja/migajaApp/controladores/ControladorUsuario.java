package cesde.migaja.migajaApp.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cesde.migaja.migajaApp.Models.Usuario;
import cesde.migaja.migajaApp.servicios.UsuarioServicio;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
@RequestMapping("/apiMigaja/v1/usuarios")
public class ControladorUsuario {

    @Autowired
    UsuarioServicio servicio;

    // Por cada servicio programo un metodo para recibir y enviar respuestas al cliente

    // funcion controladora para el servicio de guardar usuario
    @PostMapping
    public ResponseEntity<?>controladorGuardar(@RequestBody Usuario datosUsuario){
        return ResponseEntity.status(HttpStatus.CREATED).body(
            servicio.guardar_Usuario(datosUsuario)
        );
    }


    // funcion controladora para el servicio de listar usuario
    @GetMapping
    public ResponseEntity<?>controladorListar(){
        return ResponseEntity.status(HttpStatus.OK).body(
            servicio.listar_usuarios()
            
        );
    }


    // Control para modificar
    @PutMapping("/{id}")
    public ResponseEntity<?>controladorEditar(@PathVariable Integer id , @RequestBody Usuario datos){
        return ResponseEntity.status(HttpStatus.OK).body(
            servicio.actualizar_usuario(id , datos)
            
        );
    }


    // Control para eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<?>controladorEliniar(@PathVariable Integer id ){
        return ResponseEntity.status(HttpStatus.OK).body(
            servicio.eliminar_usuario(id)
            
        );
    }


    // Control para buscar por id
    @GetMapping("/{id}")
    public ResponseEntity<?>controladorBuscarPorId(@PathVariable Integer id ){
        return ResponseEntity.status(HttpStatus.OK).body(
            servicio.buscar_usuario_por_id(id)
            
        );
    }



}
