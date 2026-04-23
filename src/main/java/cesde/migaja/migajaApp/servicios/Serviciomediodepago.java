package cesde.migaja.migajaApp.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import cesde.migaja.migajaApp.Models.MedioPago;
import cesde.migaja.migajaApp.repositorios.Imediodepagorepositorio;

@Service
public class Serviciomediodepago {
    @Autowired 
    private Imediodepagorepositorio mediodepagorepositorio;

    public MedioPago guardar_medioPago(MedioPago datosmediopago){


        if (datosmediopago.getNombre().isEmpty()||datosmediopago.getNombre().isBlank()||datosmediopago.getNombre()==null){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Dato requerido"
            );
        }
        return mediodepagorepositorio.save(datosmediopago);
    }

    public List<MedioPago> listar_mediopago(){
        return mediodepagorepositorio.findAll();
    }
}