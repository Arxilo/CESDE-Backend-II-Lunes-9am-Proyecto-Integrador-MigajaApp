package cesde.migaja.migajaApp.configuracion;

import cesde.migaja.migajaApp.Models.MedioPago;
import cesde.migaja.migajaApp.Models.Usuario;
import cesde.migaja.migajaApp.Models.utils.Franquicia;
import cesde.migaja.migajaApp.repositorios.Imediodepagorepositorio;
import cesde.migaja.migajaApp.repositorios.IUsuarioRepositorio;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
@Order(2)
public class CargarDatosMedioPago implements CommandLineRunner {

    private final Imediodepagorepositorio medioPagoRepositorio;
    private final IUsuarioRepositorio usuarioRepositorio;

    public CargarDatosMedioPago(Imediodepagorepositorio medioPagoRepositorio, IUsuarioRepositorio usuarioRepositorio) {
        this.medioPagoRepositorio = medioPagoRepositorio;
        this.usuarioRepositorio = usuarioRepositorio;
    }

    @Override
    public void run(String... argumentos) {
        List<Usuario> usuarios = usuarioRepositorio.findAll();
        
        // Si no hay usuarios, no podemos asignar medios de pago
        if (usuarios.isEmpty()) {
            System.out.println("No se encontraron usuarios para asignar medios de pago.");
            return;
        }

        String[] nombresBancos = {"Bancolombia", "Davivienda", "Banco de Bogotá", "BBVA", "Nequi", "Daviplata", "ScotiaBank", "Itau"};
        Franquicia[] franquicias = Franquicia.values();
        Random aleatorio = new Random(42);
        List<MedioPago> listaMediosPago = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            String nombre = nombresBancos[aleatorio.nextInt(nombresBancos.length)] + " " + (aleatorio.nextInt(9000) + 1000);
            Franquicia franquicia = franquicias[aleatorio.nextInt(franquicias.length)];
            Boolean estado = aleatorio.nextBoolean();
            Usuario usuario = usuarios.get(aleatorio.nextInt(usuarios.size()));

            MedioPago medioPago = new MedioPago(null, nombre, franquicia, estado);
            medioPago.setUsuario(usuario);
            listaMediosPago.add(medioPago);
        }

        medioPagoRepositorio.saveAll(listaMediosPago);
        System.out.println("Se han cargado 50 registros de medios de pago.");
    }
}