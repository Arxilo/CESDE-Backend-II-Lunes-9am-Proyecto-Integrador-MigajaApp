package cesde.migaja.migajaApp.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import cesde.migaja.migajaApp.Models.Usuario;
import cesde.migaja.migajaApp.repositorios.IUsuarioRepositorio;

@Service
public class UsuarioServicio {

    //Inyectando la dependencia al repositorio Usuario
    @Autowired
    private IUsuarioRepositorio repositorio;

    // Funcion para guardar un usuario => Todo metodo para guardar deberia devolver o retornar un objeto del modelo que guarda
    public Usuario guardar_Usuario(Usuario datosDelUsuario){

        // validar que el usuario mande sus nombres
        if(datosDelUsuario.getNombre().isEmpty()|| datosDelUsuario.getNombre().isBlank() || datosDelUsuario.getNombre() == null){

            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Nombre de usuario es requerido"
            );

        }

        // validar que el documento tenga almenos 6 caracteres
        if(datosDelUsuario.getNumeroDocumento().length() < 6 || datosDelUsuario.getNumeroDocumento() == null){

            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Numero de documento debe tener al menos 6 caracteres"
            );

        }


        // Validar que el Email no esté vacío

        if (datosDelUsuario.getEmail().isEmpty() || datosDelUsuario.getEmail().isBlank() || datosDelUsuario.getEmail() == null) {

            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "El email es requerido"
            );

        }

        // Si se pasan las validaciones
        return repositorio.save(datosDelUsuario);
        
    }

    // funcion para listar usuarios
    public List<Usuario> listar_usuarios(){
        return repositorio.findAll();
    }



}
