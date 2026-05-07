package cesde.migaja.migajaApp.configuracion;

import cesde.migaja.migajaApp.Models.Usuario;
import cesde.migaja.migajaApp.Models.utils.Rol;
import cesde.migaja.migajaApp.Models.utils.TipoDocumento;
import cesde.migaja.migajaApp.repositorios.IUsuarioRepositorio;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
@Order(1)
public class CargarDatosUsuario implements CommandLineRunner {

    private final IUsuarioRepositorio usuarioRepositorio;

    public CargarDatosUsuario(IUsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    @Override
    public void run(String... argumentos) {
        String[] nombres = {"Mateo", "Valentina", "Santiago", "Camila", "Andres"};
        String[] apellidos = {"Arcila", "Gomez", "Restrepo", "Martinez", "Lopez"};
        TipoDocumento[] tiposDocumento = {
                TipoDocumento.CEDULA_DE_CIUDADANIA,
                TipoDocumento.TARJETA_DE_IDENTIDAD,
                TipoDocumento.CEDULA_DE_EXTRANJERIA
        };
        Rol[] roles = {Rol.ADMINISTRADOR, Rol.CLIENTE, Rol.EMPLEADO};
        String[] direcciones = {"Calle 10 # 20-30", "Carrera 50 # 15-25", "Avenida 80 # 45-10", "Diagonal 75 # 33-12", "Transversal 12 # 8-40"};
        Random aleatorio = new Random(42);
        List<Usuario> listaUsuarios = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            String nombre = nombres[aleatorio.nextInt(5)];
            String apellido = apellidos[aleatorio.nextInt(5)];
            TipoDocumento tipoDocumento = tiposDocumento[aleatorio.nextInt(3)];
            String numeroDocumento = String.valueOf(1000000000L + aleatorio.nextInt(900000000));
            Integer edad = 18 + aleatorio.nextInt(60);
            String email = nombre.toLowerCase() + apellido.toLowerCase() + i + "@migaja.com";
            String telefono = "3" + (100000000 + aleatorio.nextInt(899999999));
            String direccion = direcciones[aleatorio.nextInt(5)];
            Rol rol = roles[aleatorio.nextInt(3)];
            listaUsuarios.add(new Usuario(null, nombre, tipoDocumento, numeroDocumento, edad, apellido, email, telefono, direccion, rol));
        }
        usuarioRepositorio.saveAll(listaUsuarios);
    }
}
