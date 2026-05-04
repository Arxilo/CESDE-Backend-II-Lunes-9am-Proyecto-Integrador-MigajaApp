package cesde.migaja.migajaApp.servicios;

import java.util.List;
import java.util.Optional;

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
                "dato requerido"
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


    // funcion para actualizar usuario
    public Usuario actualizar_usuario(Integer id , Usuario datosNuevos){

        Optional<Usuario> usuario_busqueda = repositorio.findById(id);
        if(usuario_busqueda.isEmpty()){

            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Usuario no encontrado"
            );

        }else{

            Usuario usuario_encontrado = usuario_busqueda.get();

            // modificando datos
            usuario_encontrado.setNombre(datosNuevos.getNombre());
            usuario_encontrado.setEmail(datosNuevos.getEmail());

            return repositorio.save(usuario_encontrado);

        }


    }


    // funcion para eliminar usuario
    public boolean eliminar_usuario(Integer id){

        Optional<Usuario> usuario_busqueda = repositorio.findById(id);
        if(usuario_busqueda.isEmpty()){

            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Usuario no encontrado"
            );

        }else{

            repositorio.deleteById(id);
            return true;

        }

    }


    // funcion de buscar usuarios por id

    public Usuario buscar_usuario_por_id(Integer id ){
        
        Optional<Usuario> usuario_busqueda = repositorio.findById(id);
        if(usuario_busqueda.isEmpty()){

            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Usuario no encontrado"
            );

        }else{

            return usuario_busqueda.get();

        }

    }


}
