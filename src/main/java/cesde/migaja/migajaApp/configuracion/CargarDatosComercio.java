package cesde.migaja.migajaApp.configuracion;

import cesde.migaja.migajaApp.Models.Comercio;
import cesde.migaja.migajaApp.repositorios.Icomercio;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
@Order(2)
public class CargarDatosComercio implements CommandLineRunner {

    private final Icomercio comercioRepositorio;

    public CargarDatosComercio(Icomercio comercioRepositorio) {
        this.comercioRepositorio = comercioRepositorio;
    }

    @Override
    public void run(String... argumentos) {
        String[] nombresComercio = {"Tienda La Esquina", "Supermercado Don Jose", "Panaderia La Espiga", "Cafeteria El Aroma", "Almacen Variedades", "Ferreteria El Tornillo", "Drogueria Saludable", "Restaurante La Sazon", "Mini Mercado El Vecino", "Frutiverduras El Campo"};
        String[] actividades = {"Venta de productos de consumo masivo", "Comercio al por menor de alimentos", "Servicios de restaurante y cafeteria", "Venta de productos de ferreteria", "Comercio farmaceutico", "Venta de ropa y accesorios", "Comercio de productos tecnologicos", "Servicios de panaderia y reposteria"};
        String[] direcciones = {"Calle 10 # 20-30", "Carrera 50 # 15-25", "Avenida 80 # 45-10", "Diagonal 75 # 33-12", "Transversal 12 # 8-40"};
        String[] nombresRepresentante = {"Mateo", "Valentina", "Santiago", "Camila", "Andres"};
        String[] apellidosRepresentante = {"Arcila", "Gomez", "Restrepo", "Martinez", "Lopez"};
        Random aleatorio = new Random(42);
        List<Comercio> listaComercios = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            String nombre = nombresComercio[aleatorio.nextInt(nombresComercio.length)] + " " + (i + 1);
            Integer nit = 900000000 + i;
            String correo = "comercio" + i + "@migaja.com";
            String direccion = direcciones[aleatorio.nextInt(direcciones.length)];
            String telefono = "3" + (100000000 + aleatorio.nextInt(899999999));
            String sitioWeb = "https://www.comercio" + i + ".com";
            String actividad = actividades[aleatorio.nextInt(actividades.length)];
            String representanteLegal = nombresRepresentante[aleatorio.nextInt(nombresRepresentante.length)] + " " + apellidosRepresentante[aleatorio.nextInt(apellidosRepresentante.length)];
            listaComercios.add(new Comercio(null, nit, nombre, correo, direccion, telefono, sitioWeb, actividad, representanteLegal));
        }
        comercioRepositorio.saveAll(listaComercios);
    }
}
